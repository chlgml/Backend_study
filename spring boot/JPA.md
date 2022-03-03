**JPA**

Java Persistence API의 약자로 java OMR기술에 대한 표준 명세로 java에서 제공하는 API이다.

- OMR
  - 객체와 관계형 데이터베이스와의 설정
  - 객체와 데이터베이스 자동 매핑



**JPA의 동작과정**

JPA는 애플리케이션과 JDBC 사이에서 동작한다. 개발자가 JPA를 사용하면 JPA 내부에서 JDBC API를 사용하여 SQL를 호출하여 DB와 통신한다. 

- JDBC

  DB에 접근할 수 있도록 자바에서 제공하는 API이다.





## JPA-Repository

스프링 프레임워크에서 JPA를 편하게 지원하도록 도와줌. CRUD 처리를 위한 공통 인터페이스 제공



**JPA처리를 담당하는 Repository**

부모가 자식보다 내용이 적음! 기억해야함. 자식은 부모의 모든것을 상속하기 때문에 기능이 더 많은 것이 자식이다. 그러므로 가장 큰 기능을 사용하려면 JPARepository를 쓰고 일반적인 조회, 수정, 삭제를 하려면 CrudRepository를 사용한다. 그리고 CrudRepository는 findAll()를 할때,  Iteratable을 반환하지만 JpaRepository 는 List를 반환한다.



```java
// CrudRepository 선언
@Repository //어노테이션을 꼭 붙여야함!
public interface PersonRepository extends CrudRepository<엔티티 타입, 식별자 타입> {
}
```



## JPA-영속성 컨텍스트

영속성 컨텍스트란 이름에서 '영속성'이 나오듯 entity를 영구적으로 저장하는 환경을 말한다. 애플리케이션과 데이터베이스 사이에서 객체를 보관하는 역할을 한다. 영속성 컨턱스트는 Entity 매니저를 통해 Entity를 조회하거나 저장할때 Entity를 보관하고 관리한다.



entity의 생명주기

- 비영속 : 영속성 컨텍스트와 관계가 없는 새로운 상태, 객체 생성만한 상태
- 영속 : entity 매니저를 통해 entity가 영속성 컨텍스트에 저장되어 관리되고 있는 상태
- 준영속 : 영속성 컨텍스트에서 관리되다가 분리된 상태
- 삭제 : 영속성 컨텍스트에서 삭제된 상태



장점 

- 1차 캐시
- 동일성 보장
- 트랜잭션을 지원하는 쓰기 지연
- 변경 감지
- 지연 로딩



## JPA와 기본생성자

일단 이 글을 쓰게 된 시초는 Entity의 코드에서 @NoArgsConstructor를 삭제시 Entity의 코드에서 에러가 나는 것을 발견했다. 습관상 이유를 모르고 @NoArgsConstructor의 어노테이션을 붙여왔지만 문득 왜 에러가 나는 지 궁금해졌다.



먼저 JPA는 DB의 값을 객체 필드에 주입할 때 기본 생성자로 객체를 생성한 후 java Reflection을 사용하여 값을 매핑한다. (여기서  java Reflection란 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드와 타입변수들에 접근할 수 있도록 해주는 API이다. ) 이때 가져올 수 없는 정보 중 하나가 생성자의 인자 정보들이다. 따라서 기본 생성자가 없다면  java Reflection은 해당 객체를 생성할 수 없기 떄문에 JPA의 Entity에는 기본 생성자가 필요하다.
내가 봤을 때는 위의 이유가 클 것 같은데 하나 더 끄적여 보자면 기본생성자를 사용함으로써 setter의 사용을 줄일 수 있다고 생각한다.



