## Annotation



**@AllArgsConstructor ** : 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성



***@Builder*** : 자동으로 해당클래스에 빌드를 생성



***@Column*** : 필드와 컬럼 매핑



**@Controller**: 이 어노테이션이 적용된 클래스는 Controller라고 나타내고 bean으로 등록되며 해당 클래스가 Controller로 사용됨.

\- Controller : 인스턴스의 생명 주기 관리, 생성된 인스턴스들에게 추가적인 기능 제공

\- bean : Spring Container에서 생성되는 객체



***Component*** : 개발자가 직접 작성한 클래스를 bean으로 등록하기 위한 것



***Entity*** : 객체와 테이블 매핑



**Getter ** :  Getter 메소드를 생성해 준다.

***<필드를 public으로 하지않고 getter를 사용하는 이유>***

정보 은닉과 유효성 검사를 위해 사용한다.



***@Genertedvalue*** : 기본키 매핑을 위해 기본키 자동 생성하는 전략을 선택

(strategy = GenerationType.IDENTITY) -> 여기서는 IDENTITY라는 방법을 지정함.

\- IDENTITY : 기본키 생성을 데이터베이스에게 위임

\- SEQUENCE : 데이터베이스 시퀸스를 사용해서 기본키 할당

\- TABLE : 키 생성 테이블 사용. 키 생성 전용 테이블 하나를 만들고 이름과 값을 사용할 컬럼을 만듦.

\- AUTO : 데이터베이스 벤더에 의존하지 않음. 데이터베이스에 따라서 위의 방법중 하나를 자동 설정



***@Id*** : 기본 키 매핑



***@NoArgsConstructor*** : 파라미터가 없는 생성자 생성



***@NotNull*** : null이 아닌지 확인



***@NotEmpty*** : null이 아니고 크기가 1이상인지 확인함



**@NotBlank **: null이 아니고 단순한 띄어쓰기가 아닌지 확인



***@Override*** : 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.



***@PostMapping*** : @RequestMapping(Method=RequestMethod.Post)과 같다.

위에서 @RequestMapping 의 요청받는 방식을 정의하는 것과 비슷한 원리 어떤 요청을 처리할것인지 말하는 것. 여기서는 Post임.

@GetMapping, @PutMapping, @PatchMapping, @DeleteMapping 등 도 있다



***@RequiredArgsConstructor*** : final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 추가한다.



***@RequestMapping*** : 요청 URL을 어떤 메소드가 처리할지 매핑해준다. 요청 받는 방식을 정의하기도 한다.



***@RestController*** : @Controller + @ResponseBody , @ResponseBody를 붙이지 않아도 문자열과 JSON을 전송할 수 있음



***@ResponseBody*** : 자바 객체를 HTTP 응답 몸체로 변환



***@Repository*** : DAO 클래스에서 쓰인다. 해당 클래스를 bean으로 등록. @Component의 구체화 형태

\- DAO : 데이터메이스에 접근하는 객체를 말함.

\- bean : Spring Container에서 생성되는 객체

\-  루트 컨테이너 : 어플리케이션(프로젝트 단위)에 딱 하나만 생기는 최상위 부모 컨테이너 => 클래스가 빈에 등혹되면 컨테이너가 객체를 관리 해줌



***@RequiredArgsConstructor*** : @NonNull이나 final이 붙은 필드에 대한 생성자를 생성한다.



***@ResponseStatus*** : 예외처리 함수 앞에 사용. 요청에 대한 상태코드를 말해줌.



***@Service*** : Service Class에서 쓰인다. 비지니스 로직을 수행하는 Class하는 것을 나타내는 용도



\- 오버라이딩 : 상위 클래스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것



***@PathVariable***: 해당 URL에서 {특정값}을 변수로 받아 올 수 있다.



***@RequestBody*** : 요청이 온 데이터를 바로 Class나 Model로 매핑



***@valid***  : 유효성 검증이 필요한 객체임을 지정



**<@RequestMapping을 쓰지 않고 @PostMapping, @GetMapping처럼 따로 쓰는 이유>**

@RequestMapping을 쓰면 어떤 요청을 할 것인지 정의를 해주어야하기에  코드가 길어진다.

@RequestMapping(method=RequestMethod.Post) -> @PostMapping

그리고 @PostMapping, @GetMapping 등은 각 이름에 맞는  http 메소드의 요청과 URL을 특적 자바 메소드와 매핑하는 기능을 가지고 있음. 

URL을  @PostMapping, @GetMapping 등 옆에 하나 하나 다 써줘야 하는 데 @RequestMapping을 쓰면 생략이되어 편해진다.



<URL> 네트워크 상에서 자원이 어디있는지 알려주는 규약 -> 웹페이지의 주소

<메소드> 객체의 동작(기능)