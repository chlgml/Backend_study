
```java
@Getter  
@MappedSuperclass ----------------------------------- (1)
@EntityListeners(AuditingEntityListener.class)  ----- (2)
public abstract class BaseTimeEntity extends BaseIdEntity {  
  
    @Column(nullable = false)  
    @CreatedDate  
    private LocalDate createdDate;  
  
}
```

## (1) @MappedSuperclass
엔티티에서 공통 속성이 나타나는 경우에 공통엔티티를 추출여 엔티티를 따로 만들어서 사용하는 방법이다. -> 새로운 테이블이 만들어지지않고 속성만  추가된다.
JPA Entity class들이 해당 어노테이션이 붙은 클래스를 상속하는 경우 해당 클래스의 필드를 컬럼으로 인식하게 함.
이렇게 만들어진 엔티티는 상속을 통해 사용한다. 


## (2) @EntityListeners
@EntityListeners는 매번 해야하는 동작들을  묶은 Entity Listener 클래스를  호출해준다.
Entity Listener 클래스에서 로그를 전송해주는 클래스를 만들면 엔티티의 동작에 따라 로그를 받을 수 있다.

### Entity Listener란?
엔티티의 변화를 감지하고 테이블의 데이터를 조작하는 일을 한다.

|어노테이션|설명|
|------|----------------------------------------|
|@PostLoad|Select조회가 일어난 직후에 실행되는 메서드|
|@PrePersist|해당 엔티티를 저장하기 전에 실행되는 메서드|
|@PostPersist|해당 엔티티를 저장한 후에 실행되는 메서드|
|@PreUpdate|해당 엔티티를 업데이트하기 전에 실행되는 메서드|
|@PostUpdate|해당 엔티티를 업데이트한 후에 실행되는 메서드|
|@PreRemove|해당 엔티티를 삭제하기 전에 실행되는 메서드|
|@PostRemove|해당 엔티티를 삭제한 후에 실행되는 메서드|

### AuditingEntityListener.class
Auditing 기능을 제공한다.

**Auditing 기능이란?**
Spring Data에서 제공하는 Auditing이며, Audit는 감독하고 감시하다라는 뜻으로 해당 데이터를 보고 있다가 생성, 수정이 발생하면 자동으로 값을 넣어주는 기능이다.