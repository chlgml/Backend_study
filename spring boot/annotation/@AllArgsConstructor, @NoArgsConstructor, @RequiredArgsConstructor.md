@AllArgsConstructor, @NoArgsConstructor, @RequiredArgsConstructor 3가지는 생성자를 만들어주는 어노테이션이다. 아래와 같이 필드가 존재한다면 각 어노테이션별로 생성자가 어떻게 생성될까?
```java
private final Post post;

@NotNull
private String name;

private String age;
```


## 1. @NoArgsConstructor
 파라미터가 없는 기본 생성자를 만들어준다. 
```java
public Test() {
    
}
```

### @NoArgsConstructor(**force = true**)
final 필드를 0, false. null로 초기화 시켜준다. 
@NonNull 어노테이션이 붙어져 있는 필드는 초기화가 되지 않기 때문에 따로 초기화를 해주어야 한다.

### @NoArgsConstructor(**AccessLevel.PROTECTED**)
**기본 생성자의 호출을 막는다.** 무분별한 생성자를 만드는 것을 방지하기 위해 사용된다. 모든 필드에 대한 값이 보장 되어야 한다면 **AccessLevel.PROTECTED**을 사용하는 것이 좋다.
```java
protected Test() {
    
}
```
@NoArgsConstructor(**AccessLevel.PROTECTED**)를 통해 기본 생성자를 생성하면 위와 같이 생성된다.
> @NoArgsConstructor 어노테이션 자체는 기본 생성자를 생성해주는 어노테이션이라서 처음에는 이 옵션이 많이 헷갈렸다. 
> 하지만 이 옵션을 추가하면 옵션을 추가 하지 않았을 때랑 반대로 호출을 막는 어노테이션이 된다.

```java
@Setter
@NoArgsConstructor
public class User {
	private String userId;
	private String password;
	private String name;
}
```
위와 같은 클래스의 객체를 생성했을 때, 모두 초기화가 되어야 하는 상황이라면, 기본 생성자를 생성하게 된다면 모두가 초기화되지 않을 수 있다.
```java
public static void main(String[] args) {
	User user = new User();
	user.setUserId = "희희";
	user.setPassword = "비밀번호";
}
```
위와 같이 기본 생성자를 생성하게 된다면 따로 set메서드를 사용하여 필드를 초기화 해주어야 한다. 그 과정에서 하나이상의 필드를 초기화 하지 않아도 에러가 발생하지 않아 객체는 불완전 상태가 되어버린다.모든 생성자가 초기화 되어야하는 상황이라면 기본 생성자를 생성하지 못하도록 하는 것이 좋다.

> 참고 : @Entity 클래스에는 @NoArgsConstructor(access = AccessLevel.PRIVATE)을 적용할 수 없다.
> Entity 프록시를 만들기 위해서는 기본 생성자가 반드시 하나가 필요하기 때문

```java
@Entity
@Builder
@NoArgsConstructor(AccessLevel.PROTECTED)
public class User {
	private String userId;
	private String password;
	private String name;
}
```
@Builder와 @NoArgsConstructor(AccessLevel.PROTECTED)을 둘만 사용하게 된다면 에러가 발생한다.
이미 기본생성자가 있기 때문에 따로 생성자를 만들지 않고 빌더를 만들게 되는데 이 과정에서 모든 필드를 받는 생성자가 존재하지 않아서 에러가 발생한다. 
이를 해결하기 위해서는 모든 필드를 파라미터로 받는 생성자를 생성해야한다.


## 2. @AllArgsConstructor
모든 필드값을 파라미터로 받는 생성자를 만들어준다.
```java
public Test(String name, String age){
    this.name = name;
    this.age = age;
}
```
@AllArgsConstructor 를 사용하면 **필드 순서**에 영향을 받기 때문에 두 필드의 순서를 바꾸면 생성자의 입력 값의 순서도 바뀌게 되어 발견되지 않는 치명적 오류를 발생시킬 수 있기 때문에 따로 생성자를 만들어서 @Builder를 적용해서 사용해야 한다.


## 3. @RequiredArgsConstructor
final이나 @NotNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.
```java
public Test(String name, Post post){
    this.name = name;
    this.post = post;
}
```