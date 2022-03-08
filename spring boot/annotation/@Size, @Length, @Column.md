## @Column(length= )

Entity 코드를 작성하다가 선배께 피드백을 받은 내용이있다.

```java
@Entity
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 1)
    private Integer feeling;
    
}
```

바로 위의 코드였다. (일부분만 따옴) 내가 생각한 feeling 컬럼은 한개의 칸으로 1~5까지의 숫자를 저장하는 컬럼이었다. 하지만 선배는 length가 무얼뜻하는 것이냐고 질문을 하셨다. 나는 당연히 컬럼의 길이를 지정하는 거 아닌가? 생각을 했다. 

| INT(1) | INT(2) | INT(3) | INT(4) | INT(5) |
| ------ | ------ | ------ | ------ | ------ |
| 1      | 01     | 1      | 0001   | 00001  |
| 12     | 12     | 012    | 0012   | 00012  |
| 123    | 1234   | 123    | 0123   | 00123  |
| 1234   | 1234   | 1234   | 1234   | 01234  |
| 12345  | 12345  | 12345  | 12345  | 02345  |

위를 보자. 윗줄부터 1, 12, 123, 1234,12345를 삽입 한 결과이다. 위를 보면 어느정도 감이 잡힐것이라고 예상된다. 그러니까 컬럼어노테이션의 length는 들어가는 값의 개수 제한이 아니다...! 자리수 제한이다!! (그리고 INT(11)이 기본이다.)

```java
이 부분은 String일때는 그냥 사용해도 문제 없다.
```



## @Size

어노테이션으로 문자열의 길이가 min/max에 맞게 유효한지 확인하는 Bean Validation 어노테이션이다. (import javax.validation.constraints.Size) @Size는 JPA와 Hinernate로부터 독립적인 bran을 만들어주기 때문에 @Length보다 가볍다.

```java
public class Post {
    
    @Size(min = 10, max = 300)
    private Integer title;
    
}
```



##  @Length

Hibernate Validation 어노테이션이며 @Size와 같은 의미이다. (import org.hibernate.validator.constraints.Length)

```java
public class Post {
    
    @Length(min = 10, max = 300)
    private Integer title;
    
}
```

