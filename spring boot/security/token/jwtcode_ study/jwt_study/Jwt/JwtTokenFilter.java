package com.example.jwt_study.Jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String HEADER = "Authorization";

    private static final String PREFIX = "Bearer";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = resolveToken(request); // 토큰 가져오기

        // 유효한 토큰일때 SecurityContext에 ID저장
        if(token != null && jwtTokenProvider.validateToken(token)){ // 토큰 만료 확인
            Authentication authentication = jwtTokenProvider.getAuthentication(token); // 사용자의 인증 정보 가져오기
            SecurityContextHolder.getContext().setAuthentication(authentication); // SecurityContext에 저장
            // 요청이 정상적으로 controller 도착시, SecurityContext에 accountId 존재 보장, 하지만 DB에서 조회한것이 아니기 때문에 탈퇴로 인헤 DB에 아이디가 없는 경우등의 예외 상황 고력하기
        }
        filterChain.doFilter(request, response);

    }

    // 토큰 정보 꺼내오기
    public String resolveToken(HttpServletRequest request) {
                               // Http 프로토콜의 Request정보를 서블릿에게 전달하기 위한 목적으로 쓰인다.
        String bearerToken = request.getHeader(HEADER);
        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
                                            // .startsWith(PREFIX) : 어떤 문자열이 특정 문자로 시작하는 지 확인하여, true또는 false반환
            return bearerToken.substring(7);
                        // .substring(7) : 문자열을 자르는 메소드 7이 인자값으로 들어갔으니 7번부터 시작하여 마지막까지 자른다.
        }
        return null;
    }

}
