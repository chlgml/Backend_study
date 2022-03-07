## JPA-Annotation



### @Entity

*********

class위에 @Entity 어노테이션을 붙이면 그 클래스는 JPA가 관리하게 된다. DB 테이블과 매핑이 되는 class라면 @Entity를 붙여주어야한다.

- 필드에 final, enum, interface, class를 사용할 수 없다.
- 생성자 중 기본생성자가 반드시 필요하다

```java
@Entity(name = 엔티티 이름 지정, 기본값은 클래스 이름을 그대로 사용한다.)
```



### @Table

*************

매핑할 테이블을 지정할 때 쓰인다.

```java
@Table(name = 매핑할 테이블 이름 지정, 
       catalog = DB의 catalog를 매핑함,
       schema = DB의 스키마와 매핑,
       uniqueConstraint = DDL 쿼리 작성시 제약 조건 생성)
```



### @Column

*******

필드와 DB테이블의 컬럼 매핑

```java
@Column(name = 매핑할 컬럼 이름 지정, 
        nullable = NULL을 허용할지 않을지 결정,
        length = 길이를 조정한다. 기본값으로 255가 입력이 된다,
        unique = 해당 컬럼에 동일한 값이 들어가지 않도록 하는 제약조건을 걸때 사용,
        insertable = 엔티티 저장시 선언된 필드도 같이 저장,
        updateable = 엔티티 수정시 이 필드와 함께 수정, 
        table = 지정한 필드를 다른 테이블에 매핑,
        columnDefinition = DB 컬럼 정보를 직접적으로 지정할 때 사용,
        precsion, scale = BigInteger, BigDecimal타입에서 사용한다.)
```



### @Id

*************

기본키를 지정한다.



### @Genertedvalue 

***********

기본키 매핑을 위해 기본키 자동 생성하는 전략을 선택

```java
@Genertedvalue(strategy = GenerationType.IDENTITY) // 여기서는 IDENTITY라는 방법을 지정함.
```

- IDENTITY : 기본키 생성을 데이터베이스에게 위임

- SEQUENCE : 데이터베이스 시퀸스를 사용해서 기본키 할당

- TABLE : 키 생성 테이블 사용. 키 생성 전용 테이블 하나를 만들고 이름과 값을 사용할 컬럼을 만듦.

- AUTO : 데이터베이스 벤더에 의존하지 않음. 데이터베이스에 따라서 위의 방법중 하나를 자동 설정



### @Repository

********

DAO 클래스(Entity)에서 쓰인다. 해당 클래스를 bean으로 등록. @Component의 구체화 형태

- DAO : 데이터메이스에 접근하는 객체를 말함.        bean : Spring Container에서 생성되는 객체

- 루트 컨테이너 : 어플리케이션(프로젝트 단위)에 딱 하나만 생기는 최상위 부모 컨테이너 => 클래스가 빈에 등혹되면 컨테이너가 객체를 관리 해줌
- ***@Component*** : 개발자가 직접 작성한 클래스를 bean으로 등록하기 위한 것

```
선배가 Repository를 상속받으면 @Repository어노테이션을 붙이지 않아도 된다고 하셨다.
```



