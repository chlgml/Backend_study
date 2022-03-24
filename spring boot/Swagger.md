## Swagger

API 문서 자동화를 해준다. 코드를 바꾸게 될때 API명세서가 바뀌는 경우가 있다. 또한 사람이 API명세를 작성하다보면 실수를 하는 부분도 있기 때문에 자동 API문서가 더 편리하다.



일단, 제일 먼저 의존성을 추가해준다.

```java
implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'
```



```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.패키지)) // 패키지 적기
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("이름") // 웹 애플리케이션의 이름을 적는다.
                .version("1.0.0") // 웹 애플리케이션의 버전을 적는다.
                .description("설명") // 웹 애플리케이션의 설명을 적는다.
                .build();
    }
}
```

이렇게만 설정해주면 알아서 작성을 해준다. 근데 막상 실행해보니까 에러가 계속 났다. 알고보니까 버전 호환이 안돼는 거였다. 그래서 삽질을 한 결과 yml파일에 설정을 추가해주니 실행이 잘 되었다.

```
spring:  
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```



>사용해본 후기로는 솔직히..... 나는 객관적으로 쓰지는 못할 것 같다. 진짜 간단하게 프로젝트를 진행한다면 큰 문제는 없겠지만, 큰 프로젝트 같은 경우에는 비추한다....

