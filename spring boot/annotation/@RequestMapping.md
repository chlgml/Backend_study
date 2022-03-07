## @RequestMapping



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
그리고 @PostMapping, @GetMapping 등은 각 이름에 맞는  http 메소드의 요청과 URL을 특적 자바 메소드와 매핑하는 기능을 가지고 있음. URL을  @PostMapping, @GetMapping 등 옆에 하나 하나 다 써줘야 하는 데 @RequestMapping을 쓰면 생략이되어 편해진다.



**POST Mapping과 GET Mapping의 차이**

- GET Mapping

  get 매핑은 URL에 입력값이 노출되어 전송된다. 사용자의 ID또는 비밀번호가 노출되어 전송된다면 보안에 취약할 수 밖에 없기 때문에 노출되어도 되는 정보만 get으로 받는다. get은 대부분 정보를 조회할 때 쓰인다. 
  get 매핑은 테이터를 전송할 때 Body에 담아서 전송 할 수 없다. -> 이건 또 500 에러가 뜨지 않고 400대가 뜨고, 포스트맨으로도 통과가 되기 때문에 잘 보고 해야한다!! 

- POST Mapping

  post매핑은 전송할 데이터를 Body에 담아서 전송한다. post방식에서는 패킷안에 숨겨져서 전송된다. 데이터가 Bodt로 전송되어 눈에 보이지는 않지만, 보안이 중요한 데이터의 경우에는 암호화를 한 후 전송해야 한다. post는 정보를 생성할때 쓰인다.



**@PatchMapping과 @PutMapping의 차이**

@PatchMapping은 수정했을 때 수정되지 않는 값들은 빈값으로 처리한다. 만약 전체를 수정하는 경우가 아닐때는 나머지 수정하지 않은 값은 빈값으로 처리되는 것이다. @PatchMapping은 @PatchMapping과 다르게 수정되지 않은 값들을 빈값으로 처리하지 않는다. 

그래서 선배께 여쭤봤더니... 회사에 따라 @PatchMapping을 안쓰는 곳이 있다고 한다.
