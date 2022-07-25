## @valid

위에 있는 어노테이션과 같은 javax.validation 어노테이션이다. 이 어노테이션은 유효성 검증을 해준다. DTO에서 설정한 제약조건에 따라 valid 어노테이션이 객체를 검증한다.

controller
```java
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public PostIdResponse savePost(@Valid @RequestBody PostRequest request) {
	return postService.savePost(request);
}
```

dto
```java
@Getter
@NoArgsConstructor
public class PostRequest {

@NotBlank
@Size(max = 100)
private String title;

@NotBlank
@Size(max = 500)
private String content;

}
```
위의 dto 클래스에서 validation 어노테이션으로 설정한 제약조건에 따라 그 제약조건이 일치하는 지 검사한다. 
- title의 길이가 100이 넘는지 검사한다. 만약, 100이 넘는다면 400을 반환한다.



## @Validated
Validated 어노테이션도 valid와 마찬가지로 유효성 검사를 해주는 어노테이션이다. 하지만 valid와  다른점이 있다면 Validated 어노테이션은 제약조건을  적용시킬 그룹을 만들어서 적용이 가능하다는 것이다.

dto
```java
@Getter
@NoArgsConstructor
public class PostRequest {

	interface validGroupA {} 
	interface validGroupB {}

	@NotBlank(groups = validGroupA.class)
	@Size(max = 100)
	private String title;

	@NotBlank(groups = validGroupB.class)
	@Size(max = 500)
	private String content;

}
```
아까 봤던 dto의 필드에 그룹을 명시해주면 controller에서 그룹을 통해 원하는 필드만을 유효성 검사를 할 수 있다.

controller
```java
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public PostIdResponse savePost(@Validated(PostRequest.validGroupA.class) @RequestBody PostRequest request) {
	return postService.savePost(request);
}
```
