controller(1)

```java
@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class Controller {
                              (postService는 PostService타입의 변수로 선언한건가요?)
    						  // 원래는 new라는 키워드를 통해서 객체를 생성해야 하지만 스프링에서 해 주는 것 같다.
    private final PostService postService;
            (final는 어떻게 쓰이는 건가요?)    
            //다시 초기화를 하지 않을때, 그래서 오버라이딩이 안된다.
            (final의 정의는 위의 것인데 postService를 final형식으로 생성한건가요?)
    
                  import com.example1.demo.service.PostService;
                  public interface PostService {
                      void writePost(PostRequest request);
                                    (PostRequest타입으로 request라는 변수를 선언한건가요?)
                                    (request는 매개변수인건가요?)
                           			//PostRequest 클래스 타입으로 request의 매개변수를 만든것
                      
                                    import com.example1.demo.payload.PostRequest;
                                     @Getter
                                     @Builder
                                     // @Builder어노테이션이 붙으면 무조건 @AllArgsConstructor를 붙여야함
									 public class PostRequest {
										@NotBlank
  										private String title;
										@NotBlank
                                        private String content;
									}  
                      
                         PostsResponse getPosts();                 
                      	 import com.example1.demo.payload.PostsResponse;
                      	 public class PostsResponse {
    					 public List<Posts> posts;
						 } (이 부분은 controller(2)에 있어요.)

                         PostResponse getDetailPost(Integer id);
                  }

```
<궁금한 것>

```java
@Getter
@Builder
public class PostRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}

(위와 아래의 변수들은 이름만 같고 아예 다른 변수인가요?)
//기능들이랑 변수 이름이 같아서 한번에 모아써도 된다.PostDTO로 묶을 수 있음

@Getter
@Builder
public class PostResponse {

    private  String title;

    private String content;

}
```
