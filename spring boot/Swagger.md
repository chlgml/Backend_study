## Swagger

API 문서 자동화를 해준다. 

API명세서를 직접 작성하게 된다면, API가 변경될때마다 API명세서를 수정해야한다. 또한 사람이 API명세를 작성하다보면 실수를 하는 부분도 있기 때문에 이러한 문제점을 해결하기 위해 만들어진것이 swagger이다.



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



관련 어노테이션

- @ApiOperation : 해당 API에 대한 설명을 추가할 수 있다.

- @ApiParam : 매개변수에 대한 설명을 추가할 수 있다.

  

>사용해본 후기로는 솔직히..... 나는 객관적으로 쓰지는 못할 것 같다. 진짜 간단하게 프로젝트를 진행한다면 큰 문제는 없겠지만, 큰 프로젝트 같은 경우에는 비추한다....
>만약 사용하게 된다면 설명을 꼭 붙이는게 좋을 것 같다.

