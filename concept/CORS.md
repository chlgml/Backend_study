## CORS란,

Cross-Origin Resource Sharing의 약자로 교차 출처 지원 공유이다. 쉽게 말하면 도메인이 서로 다른 서버끼리 요청을 주고받을 때 권한을 부여하도록 브라우저에게 알려주는 체제이다. 

무분별하게 클라이언트가 다른 리소스에 접근하는 것을 막는 보안 이슈이다.

클라이언트가 3000포트이고 서버가 8080포트라면 클라이언트가 서버에 접근하면 연결을 차단한다.
포트가 다르거나 도메인이 다르거나 프로토콜이 다르다면 접근을 제한한다.



```javascript
Access to XMLHttpRequest at 'http://xxx' from origin 'http://localhost:3000' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.
```

프론트 개발중에 서버와 연결하다가 위와 같은 오류가 떴다면 CORS 오류이다.



**Spring Boot를 통한 CORS 해결방법**

```java
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 스프링 시큐리티 설정

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().configurationSource(corsConfigurationSource())
                .and()
   }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*"); // 허용할 메소드
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
```

