```java
@GetMapping("/search")
public PostListResponse FindWriter(@RequestParam("writer") ---------- (1)
                                   String writer) {
    
@DeleteMapping("/{commentsid}")
public void CommentsNo(@PathVariable("commentsid") --------------- (2)
                       Long comments_id) {
    
@PostMapping("/post")
public void SavePost(@Valid @RequestBody ------------------------ (3)
    PostRequest postRequest) {
    
@PutMapping // 아래와 같이 여러 어노테이션을 같이 쓸 수 있음.
public void UpdateComments (@PathVariable("commentsid") Long comments_id,
                            @Valid @RequestBody CommentsRequest commentsRequest, String pwd) {

```

@RequestBody, @PathVariable, @RequestParam, @RequestPart 이 어노테이션 모두 클라이언트로부터 데이터를 Controller에서 받아올 수 있도록 도와주는 것이다. 세가지 모두 값을 받아 올 수 있도록 하는 것이지만 언제 사용하는 것일까?



## (1) @RequestParam 

@RequestParam은 URL을 통하여 값을 전달받는다. @RequestBody와 다르게 @RequestParam는 객체를 생성할 수 없지만, 각 변수별로 저장할 수 있다.@RequestParam는 정렬이나 필터링을 할 때 사용한다. 예를 들어 검색할때 사용한다. 그리고 @RequestParam는 쿼리스트링을 하기 위해 쓰인다.



**Query String(쿼리 스트링)이란?**

사용자가 입력 데이터를 전달하는 방법중의 하나로, URL 주소에 미리 협의된 데이터를 파라미터를 통해 넘기는 것을 말한다.
URL에서 ?는 쿼리스트링의 시작을 알리며, &를 붙여서 여러 개의 파라미터를 넘길 수 있다.

```
엔드포인트주소/엔드포인트주소?파라미터=값&파라미터=값
```



## (2) @PathVariable

해당 URL에서 {특정값}을 변수로 받아 올 수 있다. 얘도 객체를 생성할 수 없지만 각 변수별로 저장할 수 있다. @PathVariable는 어떤 값을 식별하고 싶을 때 사용한다. 예를 들어 특정 id를 가진 게시글을 찾을 때 사용한다. 또한 @PathVariable는 패스 파라미터를 사용하기 위해 쓰인다.



**Path Variable(패스 파라미터)란?** 

PathParam도 URL을 통해 값을 넘기는 방법중 하나인데,  엔드포인트 다음으로 /다음에 값을 적어서 넘기는 방식이다.

```
엔드포인트주소/엔드포인트주소/값
```



## (3) @RequestBody

@RequestBody는 HTTP Body에서 JSON으로 던져진 값을 객체로 바꾸어 받아 오는 어노테이션이다. 객체로 바꾸어오는 어노테이션이기에 객체를 생성 할 수 있지만, 각 변수별로 저장을 할 수 없다. 



> GET은 body로 요청을 보내지 못한다. 근데 프론트쪽에서 잘 보냈는데 400이 뜬다고 해서 뭐지? 하고 있었는데 내가 @RequestBody로 설정해놓은 곳에 GETMapping을 하도록 설정해놨던 것이다...!
