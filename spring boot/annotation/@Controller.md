```java
@RequiredArgsConstructor
@RestController -------------------------------------------------- (1)
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) -------------------------- (2)
    public PostIdResponse sevePost(@RequestBody @Valid PostRequest requset) {
        return postService.sevePost(requset);
    }
}
```



## (1) @RestController

 @Controller와 @ResponseBody를 합친 어노테이션으로, @ResponseBody를 붙이지 않아도 문자열과 JSON을 전송할 수 있음

-  @Controller

  이 어노테이션이 적용된 클래스는 Controller라고 나타내고 bean으로 등록되며 해당 클래스가 Controller로 사용됨.

  - Controller : 인스턴스의 생명 주기 관리, 생성된 인스턴스들에게 추가적인 기능 제공

- @ResponseBody

  자바 객체를 HTTP 응답 몸체로 변환



## (2) @ResponseStatus

예외처리 함수 앞에 사용. 요청에 대한 상태코드를 말해줌.

```java
@ResponseStatus(HttpStatus.CREATED) 
// 사용은 위와 같이 사용하며,HttpStatus.하고 원하는 상태코드를 적어주면 된다.
```



