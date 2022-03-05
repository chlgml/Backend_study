## Annotation



**@AllArgsConstructor ** : 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성



***@Builder*** : 자동으로 해당클래스에 빌드를 생성



**@Controller**: 이 어노테이션이 적용된 클래스는 Controller라고 나타내고 bean으로 등록되며 해당 클래스가 Controller로 사용됨.

\- Controller : 인스턴스의 생명 주기 관리, 생성된 인스턴스들에게 추가적인 기능 제공

\- bean : Spring Container에서 생성되는 객체



***@Component*** : 개발자가 직접 작성한 클래스를 bean으로 등록하기 위한 것



**@Getter ** :  Getter 메소드를 생성해 준다.

***<필드를 public으로 하지않고 getter를 사용하는 이유>***

정보 은닉과 유효성 검사를 위해 사용한다.



***@NoArgsConstructor*** : 파라미터가 없는 생성자 생성



***@NotNull*** : null이 아닌지 확인



***@NotEmpty*** : null이 아니고 크기가 1이상인지 확인함



**@NotBlank **: null이 아니고 단순한 띄어쓰기가 아닌지 확인



***@Override*** : 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.



***@RequiredArgsConstructor*** : final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 추가한다.



***@RestController*** : @Controller + @ResponseBody , @ResponseBody를 붙이지 않아도 문자열과 JSON을 전송할 수 있음



***@ResponseBody*** : 자바 객체를 HTTP 응답 몸체로 변환



***@Repository*** : DAO 클래스에서 쓰인다. 해당 클래스를 bean으로 등록. @Component의 구체화 형태

\- DAO : 데이터메이스에 접근하는 객체를 말함.

\- bean : Spring Container에서 생성되는 객체

\-  루트 컨테이너 : 어플리케이션(프로젝트 단위)에 딱 하나만 생기는 최상위 부모 컨테이너 => 클래스가 빈에 등혹되면 컨테이너가 객체를 관리 해줌



***@RequiredArgsConstructor*** : @NonNull이나 final이 붙은 필드에 대한 생성자를 생성한다.



***@ResponseStatus*** : 예외처리 함수 앞에 사용. 요청에 대한 상태코드를 말해줌.



***@Service*** : Service Class에서 쓰인다. 비지니스 로직을 수행하는 Class하는 것을 나타내는 용도



***@valid***  : 유효성 검증이 필요한 객체임을 지정