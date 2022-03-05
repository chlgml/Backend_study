## Mapping 어노테이션



***@PostMapping*** : @RequestMapping(Method=RequestMethod.Post)과 같다.
위에서 @RequestMapping 의 요청받는 방식을 정의하는 것과 비슷한 원리 어떤 요청을 처리할것인지 말하는 것. 여기서는 Post임.

***@GetMapping*** , ***@PutMapping*** , ***@PatchMapping***,  ***@DeleteMapping*** 도 존재함. 위의 설명과 비슷해서 설명 생략



**요청방식**

```java
//GET Mapping
@RequestMapping(value ="", Method=RequestMethod.Get); // 또는
@GetMapping("");

//POST Mapping
@RequestMapping(value ="", Method=RequestMethod.Post); // 또는
@PostMapping("");

//@PutMapping, @PatchMapping, @DeleteMapping도 위랑 비슷하기 때문에 코드 생략

//모두 가능
@RequestMapping(value ="");
```



**@RequestMapping을 쓰지 않고 @PostMapping, @GetMapping처럼 따로 쓰는 이유**

@RequestMapping을 쓰면 어떤 요청을 할 것인지 정의를 해주어야하기에  코드가 길어진다.

@RequestMapping(method=RequestMethod.Post) -> @PostMapping

그리고 @PostMapping, @GetMapping 등은 각 이름에 맞는  http 메소드의 요청과 URL을 특적 자바 메소드와 매핑하는 기능을 가지고 있음. 

URL을  @PostMapping, @GetMapping 등 옆에 하나 하나 다 써줘야 하는 데 @RequestMapping을 쓰면 생략이되어 편해진다.



**POST Mapping과 GET Mapping의 차이**

- GET Mapping

  get 매핑은 URL에 입력값이 노출되어 전송된다. 사용자의 ID또는 비밀번호가 노출되어 전송된다면 보안에 취약할 수 밖에 없기 때문에 노출되어도 되는 정보만 get으로 받는다. get은 대부분 정보를 조회할 때 쓰인다. 

- POST Mapping

  post매핑은 전송할 데이터를 Body에 담아서 전송한다. post방식에서는 패킷안에 숨겨져서 전송된다. 데이터가 Bodt로 전송되어 눈에 보이지는 않지만, 보안이 중요한 데이터의 경우에는 암호화를 한 후 전송해야 한다. post는 정보를 생성할때 쓰인다.



**@PatchMapping과 @PutMapping의 차이**

@PatchMapping은 수정했을 때 수정되지 않는 값들은 빈값으로 처리한다. 만약 전체를 수정하는 경우가 아닐때는 나머지 수정하지 않은 값은 빈값으로 처리되는 것이다. @PatchMapping은 @PatchMapping과 다르게 수정되지 않은 값들을 빈값으로 처리하지 않는다. 

그래서 선배께 여쭤봤더니... 회사에 따라 @PatchMapping을 안쓰는 곳이 있다고 한다.



**@RequestBody, @PathVariable, @RequestParam**

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

