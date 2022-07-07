## Object Mapper
Object Mapper은 Java 객체를 JSON으로 serialization 하거나 JSON을 Java 객체로 deserialization할때 사용하는 Jackson 라이브러리이다. 

```java
@Getter
@NoArgsConstructor
public class Post {

    private String name;

    private String title;

    private String content;

    @Builder
    public Post (String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

}
```

### JAVA -> JSON
```java
    public static void main(String[] args) {
    
        ObjectMapper objectMapper = new ObjectMapper();

        Post post = new Post("이름", "제목", "내용");
        objectMapper.writeValue(new File("src/person.json"), post);
        // 여기서 writeValue 메소드를 통해서 Java 객체 Post를 JSON으로 바꿔준다.
        
    }
```

**new File("src/person.json")**
이 부분은 JSON을 저장할 파일을 지정하는 부분이다. 
저장할 파일을 파라미터로 넘기면 그 파일 안에 JSON파일이 저장된다.

Java 객체에 Getter이 있어야 Java객체를 JSON으로 바꿀 수 있다.

### JSON -> JAVA
```java
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\"name\":\"이름\",\"title\":제목,\"content\":\"내용\"}";
        Post post = objectMapper.readValue(json, Post.class);
        // 여기서 readValue 메소드를 통해서 JSON을 Java 객체로 바꿔준다.
        
    }
```

Java 객체에 생성자가 있어야 JSON을 Java 객체로 바꿀 수 있다.