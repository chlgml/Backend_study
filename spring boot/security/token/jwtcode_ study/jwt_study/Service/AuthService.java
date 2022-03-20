package com.example.jwt_study.Service;

import com.example.jwt_study.Dto.AccountReqest;
import com.example.jwt_study.Dto.JwtToken;
import com.example.jwt_study.Entity.Account.Account;
import com.example.jwt_study.Entity.Account.AccountRepository;
import com.example.jwt_study.Entity.RefreshToken.RefreshToken;
import com.example.jwt_study.Entity.RefreshToken.RefreshTokenRepository;
import com.example.jwt_study.Exception.ConflictException;
import com.example.jwt_study.Exception.NotFoundException;
import com.example.jwt_study.Exception.UnauthorizedException;
import com.example.jwt_study.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final PasswordEncoder encoder;
    private final AccountRepository accountRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;


    public JwtToken login (AccountReqest reqest) {

        Account account = accountRepository.findByAccountId(reqest.getAccountId())
                .orElseThrow(NotFoundException::new);

        // 토큰 발행
        return JwtToken.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(account.getAccountId()))
                .refreshToken(jwtTokenProvider.getRefreshToken(account.getAccountId()))
                .build();

    }

    public JwtToken signup (AccountReqest reqest) {

        String accountId = accountRepository.save(
                Account.builder()
                        .name(reqest.getName())
                        .accountId(reqest.getAccountId())
                        .pwd(encoder.encode(reqest.getPwd()))
                        .build()
        ).getAccountId();

        // 토큰 발행
        return JwtToken.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(accountId))
                .refreshToken(jwtTokenProvider.getRefreshToken(accountId))
                .build();

    }

    // 토큰 재발급
    @Transactional
    public JwtToken tokenRefresh(JwtToken jwtToken) {

        Authentication authentication = jwtTokenProvider.getAuthentication(jwtToken.getAccessToken());

        RefreshToken refreshToken = refreshTokenRepository.findById(authentication.getName())
                .orElseThrow(NotFoundException::new);

        if (!refreshToken.getRefreshToken().equals(jwtToken.getRefreshToken())) {
            throw new UnauthorizedException();
        }

        JwtToken token = JwtToken.builder()
                .refreshToken(refreshToken.getRefreshToken())
                .accessToken(jwtTokenProvider.generateAccessToken(authentication.getName()))
                .build();

        RefreshToken newRefreshToken = refreshToken.update(token.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return token;

    }

}
