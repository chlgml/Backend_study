## Annotation



**@Controller**: 이 어노테이션이 적용된 클래스는 Controller라고 나타내고 bean으로 등록되며 해당 클래스가 Controller로 사용됨.

\- Controller : 인스턴스의 생명 주기 관리, 생성된 인스턴스들에게 추가적인 기능 제공

\- bean : Spring Container에서 생성되는 객체



***@Override*** : 오버라이딩을 원하는 메소드위에 선언하면 오버라이딩이 제대로 되지 않을 시 알려준다.



***@RestController*** : @Controller + @ResponseBody , @ResponseBody를 붙이지 않아도 문자열과 JSON을 전송할 수 있음



***@ResponseBody*** : 자바 객체를 HTTP 응답 몸체로 변환



***@ResponseStatus*** : 예외처리 함수 앞에 사용. 요청에 대한 상태코드를 말해줌.



***@Service*** : Service Class에서 쓰인다. 비지니스 로직을 수행하는 Class하는 것을 나타내는 용도
