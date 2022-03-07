### @RequestBody, @PathVariable, @RequestParam

*********

***@RequestBody*** : 요청이 온 데이터를 바로 Class나 Model로 매핑

***@PathVariable***: 해당 URL에서 {특정값}을 변수로 받아 올 수 있다.



@RequestBody, @PathVariable, @RequestParam 이 세가지 모두 클라이언트로부터 데이터를 Controller에서 받아올 수 있도록 도와주는 것이다. 세가지 모두 값을 받아 올 수 있도록 하는 것이지만 언제 사용하는 것일까?

- 일단 @RequestBody는 HTTP Body에서 JSON으로 던져진 값을 객체로 바꾸어 받아 오는 것이다. 하지만 @PathVariable, @RequestParam는 @RequestBody와 다르게 URL을 통하여 값을 전달받는다.

- @RequestBody는 객체를 생성 할 수 있지만, 각 변수별로 저장을 할 수 없다. 그와 반대로 @RequestParam는 객체를 생성할 수 없지만, 각 변수별로 저장할 수 있다.

- @PathVariable는 어떤 값을 식별하고 싶으면 사용하고, @RequestParam는 정렬이나 필터링을 할 때 사용한다.

  또한 @PathVariable는 패스 파라미터를 사용하기 위해 쓰며, @RequestParam는 쿼리스트링을 하기 위해 쓰인다.
  
  - 쿼리 스트링이란,
  
    사용자가 입력 데이터를 전달하는 방법중의 하나로, URL 주소에 미리 협의된 데이터를 파라미터를 통해 넘기는 것을 말한다. 
  
    URL에서 ?는 쿼리스트링의 시작을 알리며, &를 붙여서 여러 개의 파라미터를 넘길 수 있다.
  
    엔드포인트주소/엔드포인트주소?파라미터=값&파라미터=값

```java
@GetMapping("/search") // 검색
public PostListResponse FindWriter(@PathParam("writer") String writer) {
    
@DeleteMapping("/{commentsid}/elmnt") // 삭제
public void CommentsNo(@PathVariable("commentsid") Long comments_id) {
    
@PostMapping("/post") // 게시글 작성
public void SavePost(@Valid @RequestBody PostRequest postRequest) {
    
@PutMapping // 게시글 수정
public void UpdateComments (@PathVariable("commentsid") Long comments_id,
                            @Valid @RequestBody CommentsRequest commentsRequest, String pwd) {
```

