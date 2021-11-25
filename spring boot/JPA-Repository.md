## JPA-Repository



### JPA

Java Persistence API의 약자로 java OMR기술에 대한 표준 명세로 java에서 제공하는 API이다.

- OMR
  - 객체와 관계형 데이터베이스와의 설정
  - 객체와 데이터베이스 자동 매핑



**JPA의 동작과정**

JPA는 애플리케이션과 JDBC 사이에서 동작한다. 개발자가 JPA를 사용하면 JPA 내부에서 JDBC API를 사용하여 SQL를 호출하여 DB와 통신한다. 

- JDBC

  DB에 접근할 수 있도록 자바에서 제공하는 API이다.



### Repository

스프링 프레임워크에서 JPA를 편하게 지원하도록 도와줌. CRUD 처리를 위한 공통 인터페이스 제공



**JPA처리를 담당하는 Repository**



<img src="C:\Users\user\Desktop\다운로드.jpg" alt="다운로드" style="zoom:150%;" />

부모가 자식보다 내용이 적음! 기억해야함. 자식은 부모의 모든것을 상속하기 때문에 기능이 더 많은 것이 자식이다. 그러므로 가장 큰 기능을 사용하려면 JPARepository를 쓰고 일반적인 조회, 수정, 삭제를 하려면 CrudRepository를 사용한다. 그리고 CrudRepository는 findAll()를 할때,  Iteratable을 반환하지만 JpaRepository 는 List를 반환한다.



```java
// CrudRepository 선언
@Repository //어노테이션을 꼭 붙여야함!
public interface PersonRepository extends CrudRepository<엔티티 타입, 식별자 타입> {
}
```





