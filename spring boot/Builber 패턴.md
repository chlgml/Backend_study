## Builber 패턴



#### int name, age, Phone_number, job;

→  이름과 나이만 받는다면 전화번호와 지역 값은 null이 된다.

→  이름, 전화번호만 받는 다거나, 나이 전화번호만 받는다는 등의 여러 경우의 수가 존재하는데 모든 경우의 수 만큼 생성자를 만들 수 없기 때문에 빌더 패턴을 사용한다.

→  파라미터 값을 순서에 맞게 넘기고 받아야 한다. 빌더 패턴을 이용한다면 순서를 신경쓰지 않아도 되며, 바로 어떤 값을 넘겨받았는지 알 수 있다.



<빌더 패턴 예시>

```java
public void save(userDto userdto) {
    UserEntity userEntity = UserEntity.builber()
        .name(userdto.getname)
        .age(userdto.getage)
        .Phone_number(userdto.Phone_number)
        .job(userdto.getjob)
        .build();
    }
```



@Builder : 빌더를 자동 생성해줌