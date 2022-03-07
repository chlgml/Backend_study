## 생성자 - Annotation



### @NoArgsConstructor

 파라미터가 없는 기본 생성자를 만들어준다.

```java
public Test() {
    
}
```

### @AllArgsConstructor

모든 필드값을 파라미터로 받는 생성자를 만들어준다.

```java
public Test(String name, String age){
    this.name = name;
    this.age = age;
}
```



### @RequiredArgsConstructor

final이나 @NotNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.

```java
@NotNull
private String name;
private final Post post;
private String age;

public Test(String name, Post post){
    this.name = name;
    this.post = post;
}

```



