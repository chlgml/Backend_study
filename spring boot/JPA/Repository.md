## JPA Repository

스프링 프레임워크에서 JPA를 편하게 지원하도록 도와줌. CRUD 처리를 위한 공통 인터페이스 제공



**JPA처리를 담당하는 Repository**

부모가 자식보다 내용이 적음! 기억해야함. 자식은 부모의 모든것을 상속하기 때문에 기능이 더 많은 것이 자식이다. 그러므로 가장 큰 기능을 사용하려면 JPARepository를 쓰고 일반적인 조회, 수정, 삭제를 하려면 CrudRepository를 사용한다. 그리고 CrudRepository는 findAll()를 할때,  Iteratable을 반환하지만 JpaRepository 는 List를 반환한다.



```java
// CrudRepository 선언
@Repository //어노테이션을 꼭 붙여야함!
public interface PersonRepository extends CrudRepository<엔티티 타입, 식별자 타입> {
}
```







## JPA와 기본생성자

일단 이 글을 쓰게 된 시초는 Entity의 코드에서 @NoArgsConstructor를 삭제시 Entity의 코드에서 에러가 나는 것을 발견했다. 습관상 이유를 모르고 @NoArgsConstructor의 어노테이션을 붙여왔지만 문득 왜 에러가 나는 지 궁금해졌다.



먼저 JPA는 DB의 값을 객체 필드에 주입할 때 기본 생성자로 객체를 생성한 후 java Reflection을 사용하여 값을 매핑한다. (여기서  java Reflection란 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메소드와 타입변수들에 접근할 수 있도록 해주는 API이다. ) 이때 가져올 수 없는 정보 중 하나가 생성자의 인자 정보들이다. 따라서 기본 생성자가 없다면  java Reflection은 해당 객체를 생성할 수 없기 떄문에 JPA의 Entity에는 기본 생성자가 필요하다.
내가 봤을 때는 위의 이유가 클 것 같은데 하나 더 끄적여 보자면 기본생성자를 사용함으로써 setter의 사용을 줄일 수 있다고 생각한다.





## JPA 하이버네이트

자바 언어를 위한 ORM 프레임워크이다. JPA 구현체의 한 종류이다. JPA 인터페이스를 구현하며, 내부적으로 JDBC API를 사용한다.

JPA는 관계형 데이터베이스와 객체의 패러다임 불일치 문제를 해결 할 수 있으며, 영속성 컨텍스트 제공해준다.

