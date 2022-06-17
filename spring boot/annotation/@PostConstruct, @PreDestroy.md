## 스프링 빈의 이벤트 사이클
스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 ->스프링 종료

- 초기화 콜백 : 빈이 생성되고 의존관계 주입 후 호출
- 소멸전 콜백 : 빈이 소멸되기 직전에 호출

스프링 빈 생명주기 콜백 방법
1. 인터페이스
2. 설정 정보 초기화 메소드, 종료 메소드 지정
3. @PostConstruct, @PreDestroy  // 이게 스프링에서 가장 권장하는 방법이라고 한다.



## @PostConstruct
- 객체가 생성되고 별도의 초기화 작업을 위해 실행하는 메소드를 선언한다.
- @PostConstruct 어노테이션을 설정해놓은 init 메소드는 WAS가 띄워질 때 실행된다.

```java
@PostConstruct  
public void initialize() {  
    // 초기화 메소드  
}
```


##  @PreDestroy
- 스프링 컨테이너에서 스프링 빈을 제거하는 작업전에 하는 메소드 위에 사용하는 어노테이션

```java
@PreDestroy 
public void destroy() { 
	// 종료 메소드
}
```

