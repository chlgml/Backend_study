package com.example.jwt_study.Jwt;

import com.example.jwt_study.Jwt.Details.Details;
import com.example.jwt_study.Jwt.Details.DetailsService;
import com.example.jwt_study.Entity.RefreshToken.RefreshToken;
import com.example.jwt_study.Entity.RefreshToken.RefreshTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value("${auth.jwt.exp.access}")
    private Long accessTokenTime;

    @Value("${auth.jwt.exp.refresh}")
    private Long refreshTokenTime;

    private final DetailsService detailsService;

    private final RefreshTokenRepository refreshTokenRepository;

    // RefreshToken 저장
    public String getRefreshToken(String accountId) {
        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .id(accountId)
                        .refreshToken(generateRefreshToken(accountId))
                        .build()
        ).getRefreshToken();
    }

    // AccessToken 생성
    public String generateAccessToken(String accountId) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenTime * 1000)) // 만료날짜 섦정
                                        // System.currentTimeMillis() : 만약 2022년 1월 15일이면 20220115로 출력해줌
                .setIssuedAt(new Date()) // Date 클래스는 현제 날짜와 시간을 출력한다.
                .setHeaderParam("typ", "access") // 해더 타입지정
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setSubject(accountId) // payload sub(토큰 제목)
                .compact();
    }

    // RefreshToken 생성
    public String generateRefreshToken(String accountId) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenTime * 1000))
                .setIssuedAt(new Date())
                .setHeaderParam("typ", "refresh")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setSubject(accountId)
                .compact();
    }


    // 권한 가져오기
    public Authentication getAuthentication(String token) {

        Details details = detailsService.loadUserByUsername(subject(token));
        return new UsernamePasswordAuthenticationToken(details,"",details.getAuthorities());

    }

    // 토큰의 유효성 검증
    public boolean validateToken(String token) {

        try {                                   // .after() : date값이 주어진 date값보다 이후면 false반환
            return getBody(token).getExpiration().after(new Date());
                                // .getExpiration() : 토큰의 만료 시간을 읽는다.
        } catch (Exception e) {
            throw new UnauthorizedException();
        }

    }

    // 토큰의 Body를 불러옴
    private Claims getBody(String token) {
                                                                    // .getBody() : 토큰의 Body내용을 가져온다. (.getHeader(), .getsignature()도 있다.)
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
                // .parser() : 토큰 파싱            // .parseClaimsJws(token) : 토큰을 Jws로 파싱

        // Jws란, JSON Web Signature의 약자로 서버에서 인증을 증거로 인증정보를 서버의 privatekey로 서명한 것을 토큰화 한것
        // 구조 : Header(JSON) + payload(JSON) + signature 간단하게 셜명하면 토큰을 JSON형태로 풀었다고 생각하면 된다.
    }

    // 토큰의 제목 id를 불러옴
    private String subject(String token) {
        try {
            return getBody(token).getSubject();
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }

}
