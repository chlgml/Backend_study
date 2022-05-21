
```java
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) ---- (1)
public class UserResponse {  

	@JsonIgnore ---------------------------------------- (2)
	private Long id;
  
    private String userId;  
  
    private String password;  

	@JsonProperty("user_id") ---------------------------- (3)
    private String name;
    
}
```


## (1) @JsonNaming
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
이런식으로 클래스에서 선언해주면 모든 필드의 표기법이 스네이크 표기법으로 바뀌어 반환된다.

```JSON
{
	"id" : 1,
	"userId" : "아이디",
	"password" : "비밀번호",
	"name" : "이름"
}
```

```JSON
{
	"id" : 1,
	"user_id" : "아이디", // 이런식으로 표기법이 바뀐 후 반환된다.
	"password" : "비밀번호",
	"name" : "이름"
}
```


## (2) @JsonIgnore
response 반환시 이 어노테이션이 붙은 필드는 Json으로 변환되지 않는다.

```JSON
{
	"id" : 1,
	"userId" : "아이디",
	"password" : "비밀번호",
	"name" : "이름"
}
```
원래는 id도 같이 반환되어야 하지만, @JsonIgnore을 붙이면,
```JSON
{
	"userId" : "아이디",
	"password" : "비밀번호",
	"name" : "이름"
}
```
이런식으로 id가 제외되어 반환된다.


## (3) @JsonProperty
response JSON의 필드명이 변경되어서 반환된다.

```JSON
{
	"id" : 1,
	"userId" : "아이디",
	"password" : "비밀번호",
	"name" : "이름"
}
```
원래는 response클래스의 필드의 이름인 name으로 JSON이 반환되었지만,
```JSON
{
	"id" : 1,
	"userId" : "아이디",
	"password" : "비밀번호",
	"user_name" : "이름"
}
```
이런식으로 이름이 설정한값대로 변경되어 반환된다.
