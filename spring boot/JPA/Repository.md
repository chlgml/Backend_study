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


## JPA 하이버네이트

자바 언어를 위한 ORM 프레임워크이다. JPA 구현체의 한 종류이다. JPA 인터페이스를 구현하며, 내부적으로 JDBC API를 사용한다.

JPA는 관계형 데이터베이스와 객체의 패러다임 불일치 문제를 해결 할 수 있으며, 영속성 컨텍스트 제공해준다.

