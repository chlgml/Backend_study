```java
@Service -------------------------------------------------------- (1)
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override --------------------------------------------------- (2)
    public void writePost(PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        postRepository.save(post);
    }
    
}
```



## @Override

오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.

[오버라이딩](https://github.com/chlgml/Backend_study/blob/master/java/OOP.md#4-%EB%8B%A4%ED%98%95%EC%84%B1) : 상위 클래스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것



## @Service

Service Class에서 쓰인다. 비지니스 로직을 수행하는 Class하는 것을 나타내는 용도