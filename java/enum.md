## Enum

흔히 상수를 정의할 때, final static String과 같은 방식으로 상수를 정의하는데 이렇게 정의를 하면 문제가 발생 할 수 있다. 이를 보완하기 위한것이 enum이다. enum은 열거형으로 불리며, 서로 연관된 상수들의 집합이다.
클라이언트로부터 오는 값이 지정되어 있을 때 사용한다.



ex)

```java
// 어느 entity의 필드
@Enumerated(EnumType.STRING) // Enum 타입의 entity클래스의 속성으로 사용
							 // EnumType.STRING : enum 이름을 DB에 저장
							 // EnumType.CRDINAL : enum 순서값을 DB에 저장
private Authority authority;

// Authority
public enum Authority {
    ROLE_USER, ROLE_ADMIN
}

public enum Sex {
    WOMAN("여성"), MAN("남자") // 상수 필드값 괄호 안에 value값을 저장할 수 있다.

	private final String sex; // 이 필드로 value값을 가져올 수 있다.

	public Sex(String sex) {
		this.sex = sex;
	}
}
```



장점

- 코드가 단순해지며, 가독성이 좋아진다.
- 인스턴스 생성과 상속을 방지 -> 상수 값의 타입 안정성 보장
- enum을 사용하기에 구현의 의도를 분명하게 할 수 있다.

