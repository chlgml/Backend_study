## @Builber

자동으로 해당클래스에 빌드를 생성


### Builber 패턴
```java
public class UserResponse {
	private int name;
	private int age;
	private String phoneNumber;

	@Builber // 빌더 어노테이션은 생성자 위에 붙여주는 것이 좋다.
	public UserReaponse(int name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
}
```

- 이름과 나이만 받는다면 전화번호와 지역 값은 null이 된다.
- 이름, 전화번호만 받는 다거나, 나이 전화번호만 받는다는 등의 여러 경우의 수가 존재하는데 모든 경우의 수 만큼 생성자를 만들 수 없기 때문에 빌더 패턴을 사용한다.
- 파라미터 값을 순서에 맞게 넘기고 받아야 한다. 빌더 패턴을 이용한다면 순서를 신경쓰지 않아도 되며, 바로 어떤 값을 넘겨받았는지 알 수 있다.

```java
public void test(userDto userdto) {
    UserResponse userResponse = UserResponse.builber()
        .name(userdto.getname)
        .age(userdto.getage)
        .Phone_number(userdto.Phone_number)
        .build();
    }
```





## @Getter

Getter 메소드를 생성해 준다.

[Getter에 대한 설명 - 캡슐화] (https://github.com/chlgml/Backend_study/blob/master/java/OOP.md).

- 필드를 public으로 하지않고 getter를 사용하는 이유 : 정보 은닉과 유효성 검사를 위해 사용한다.





