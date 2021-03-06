## controller(2)

```java
	@PostMapping
                               //CREATED이 Http상태코드 201을 뜻함.
    @ResponseStatus(HttpStatus.CREATED)
    (이 어노테이션은 언제 예외처리를 하는 것일까? 어떻게 되었을 때, 신호를 보내주는 것인지 모르겠다.)
	//예외처리가 아니라 controller에서 service로 갔다가 다시 돌아올때, 클라이언트에게 보낼 Http신호
    public void writePost(@RequestBody @Valid PostRequest request) {
                                                         (PostRequest의 형식으로 request라는 매개변수를 만든건가?)
        												 //맞음
                                              import com.example1.demo.payload.PostRequest;
        									  @Getter
											  @Builder
								  			  public class PostRequest {
											  @NotBlank
     										  private String title;
  											  @NotBlank
                                              private String content;
                                              }
        
        postService.writePost(request);
        (postService가 interface인데 interface는 구체적인 내용이 없는데 interface안의 writePost를 불러오면
         postService가 상속되어 있는 PostServiceImpl안의 writePost가 실행되는 건가? 
         interface를 실행하면 자연스럽게 interface를 상속받은 클래스가 작동하는 건가요?)
        //맞음. interface를 물려받은 PostServiceImpl의 writePost가 실행된다.
        //만약 interface가 여러개라면 <예> PostService postService = new PostServiceImpl(); 
        //이런식으로 지정하면 된다.(근데 인터페이스를 여러개 만드는 일은 별로 없음)
        import com.example1.demo.service.PostService;
        public interface PostService {
    		void writePost(PostRequest request);
            			   (여기서의 매개변수가 controller에서의 request와 똑같은 형식인데 
                            PostRequest형식으로 받아서 PostRequest형식으로 작업을 하겠다는 건가?)
            				//controller와 service가 정보를 주고 받고 있기 때문에 같은 형식으로 작업함.
        	
            PostsResponse getPosts();
            import com.example1.demo.payload.PostsResponse;
            public class PostsResponse {
    			public List<Posts> posts;
                       (posts라는 변수를 선언한 것 같긴한데, 앞에 List<Posts>는 뭔가요? 
                        List안의 Posts는 Posts클래스를 말하는 건가요? 불러온 흔적이 없는 데...
                        그리고 List가 정확히 어떤 건가요?)
                		//는 배열이긴한데 유동성있는 배열이다.
			}
            
    		PostResponse getDetailPost(Integer id);
		}

    }
```


***



만약,  postService.writePost(request);가 PostServiceImpl안의 writePost를 실행해서 작업하는 거라면

```java
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
                  import com.example1.demo.entity.PostRepository;
   				   @Repository
				   public interface PostRepository extends CrudRepository<Post, Integer> {
				                                   (extends와 implements의 차이점은 무엇인가요? 
                                                    //
				                                    CrudRepository는 뭐하는 건가요? 
                                                    // Repository 종류 중 하나로 CrudRepository안의 
                                                    // 메소드의 기능을 사용 할 수 있도록 해 준다.
				                                    <괄호>안의 Post는 무얼 뜻하나요?)
                       								// Repository를 상속할 때, 
                       								// CrudRepository<Entity클래스, ID 필드의 자료형>
  					 	List<Post> findAllBy();
  					 	           (findAllBy()는 뭐하는 건가요?)
                       				// 전체 레코드를 불러온다. CrudRepository의 메소드중 하나이다.
				   }

    @Override
    public void writePost(PostRequest request) {
        Post post = Post.builder()
                         (어노테이션으로도 builder를 생성했는데 builder생성하는 이유와 builder가 무엇인가요?)
            				// 빌더를 사용하는 이유는 어떤 값을 넘겨받았는지 알 수 있으며,
            				// 받을 값에 대한 경우의 수가 많기 때문에 모든 경우의 수의 생성자를 만들지 않기 위해
                .title(request.getTitle())
                 (왜 .title뒤에 괄호안에 request.getTitle()를 붙이는 건가요?)
            	// .title는 Entity의 필드이며 DB에 저장할 값 필드이다. 
            	// Entity 필드 안에 request의 필드 Title을 get하여 가져와 값을 넣은 것이다.
                .content(request.getContent())
                .build();
         import com.example1.demo.entity.Post;
         public class Post {
   		 @Id
   		 @GeneratedValue (strategy = GenerationType.IDENTITY)
   		 private  Integer id;
 		 @Column (nullable = false, length = 20)
   		 private  String title;
   		 (private인데 어떻게 post.해서 바로 접근이 가능한가요?)
          // 빌더 패턴을 통해 접근한 것이다.
		 @Column (nullable = false,length = 300)
		 (false가 된다면 어떻게 처리가 되는 건가요?)
           
		 private String content;
		 }

        postRepository.save(post);
                       (무얼 불러온 건가요?)
        				// seve라는 CrudRepository의 메소드를 통해서 post의 값을 DB에 저장한 것임
    }

( 생략 )
```

