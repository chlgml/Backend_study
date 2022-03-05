**Class - 객체를 정의하는 틀(설계도)**

- 객체 : 자신의 속성을 가지고 있고 다른 것과 식별 가능한 것을 말함.

  - 필드 (속성) : 클래스에 포함된 '변수'

  - 메소드 (동작)  : 특정 작업 수행용 명령문의 집합

    예) 클래스 (Class) : 차(car) 설계도

  ​                 필드 (field) : car.modelName = "람보르기니"

  ​                                           car.modelYear = 2016

  ​                 메소드 (method) : car.accelerate()

  ​                                                      car. brake()

- 구성 :  상태를 나타내는 필드 + 행동을 나타내는 메소드



**접근 제어자 - 정보 은닉을 위해 사용**

1. Private                                         2. default                                       3.Public                                           4. Protected

<접근 범위>

| 접근 제어자 | 클래스 내부 | 같은 패키지 | 하위패키지 | 다른패키지 |
| :---------: | :---------: | :---------: | :--------: | :--------: |
|   Public    |      O      |      O      |     O      |     O      |
|  Protected  |      O      |      O      |     O      |     X      |
|   default   |      O      |      O      |     X      |     X      |
|   Private   |      O      |      X      |     X      |     X      |

- 패키지 : 클래스와 인터페이스의 집합
  - 인터페이스 : 극단적으로 동일한 목적하에 동일한 기능을 수행하게는끔 하는 것이 인터페이스의 역할이자 개념



**Java 문법**

```java
import java.util.scanner // scanner 라이브러리를 불러옴.
import java.util.* // 모든 라이브러리
```

라이브러리 : 패키지를 배포 용의성의 위해 압축한 상태로 라이브러리를 사용하면 라이브러리안의 기능들을 사용 할 수 있다.

> 출력
>
> C => Java
>
> ```java
> printf("%d\n", 2+1); => system.out.println(2+1); // sout(자동 생성 단축키), 엔터가 자동으로 출력됨
> ```
>
> 숫자_ (2+1) 괄호 안에 그대로 입력          문자_ ('희') 작은 따옴표 안에 입력          문자열_ ("최희") 큰 따옴표 안에 입력
>
> *문자열 + 숫자 + 문자열_ ("문자와 숫자 "+ 3 + "을 출력");

> 변수 (자료형)
>
> 정수  : int               실수 : double               문자열 : string 
>

> 메소드의 정의와 호출
>
> ```java
> public static void Hee() {
>   system.out.println("안녕하세요.");
> } // 메소드 정의
> public static void main(String[]args) {
>  Hee(); // 메소드 호출
> } 
> ```
>
> 메소드의 정의와  호출은 C언어의 함수와 유사함.
>
> ```java
> public static void Hee(int num) {
>                        // 파라미터, 매개변수
>     for (int i = 0; i < num; i++) {
>         System.out.println(i);
>     }
> }
>    
> public static void main(String[] args) {
>     Hee(5);
>         // 인수, 인자
> }
> ```

> 입력과 출력
>
> C => Java
>
> ``` java
> int main() => public static void main(String[]args)
> ```
>
> public static void**(main이라는 메소드의 값이 존재하지 않는다.)** main**(메소드)**
>
> (String**(문자열)**[]**(문자열을 담을 수 있는 배열)**args**(args라는 이름의 변수)**) => 파라미터 (매개변수)
>
> ``` java
> scanf("%d", &i); => scanner sc = new scanner(system,.in); int i = sc. nextint();
> ```

> new : 객체 생성 
>
> ``` java
> Class 변수명 =  new 생성자();
> 인스턴스.메소드명(); //c언어의 구조체 안의 변수를 불러오는 듯이 '.'을 통해 불러올 수 있음. 
> ```
>
> - 여기서 생성된 변수를 인스턴스라고 한다.
>   - 인스턴스 : 객체를 소프트웨어에 실체화 한 것 
> - C언어를 예로 들면 구조체와 함수를 섞어 놓은 것이라고 볼 수 있음. 구조체처럼 여러개를 선언할 수 있고, 함수처럼 쓰임.

> 생성자  : 클래스가 인스턴스화 될때 생성되는필드를 초기화 하는 멤버, 초기값 설정
>
> ​               *만약 생성자를 설정하지 않았다면 컴파일러에서 자동으로 생성해준다.
>
> ``` java
> class Choi {
> 	int a;
> 	int b;
> 
> 	public Choi() { 
> 		a = 10;
> 		b = 20;
> 	} // 기본 생성자
> 
> 	public Choi(int n1, int n2) { 
> 		a = n1;
> 		b = n2;
> 	} // 생성자 오버로딩
> 
> 	public void sum() { 
> 		System.out.println("합계 : " + (a + b));
> 	} // 메소드
> }
> 
> public class Hello {
> 	public static void main(String[] args) {
> 		Choi Hee = new Choi();
>      // 초기화를 따로 해 주지 않았기 때문에 Choi에서 초기화 된 값 그대로 사용
> 		Hee.sum(); // 30 출력
> 
> 		Choi cc2 = new Choi(0, 10);
>      // 초기화를 다시 해 주었기 때문에 Choi의 a, b값이 바뀌게 되어 바뀐 값 사용
> 		cc2.sum(); // 10 출력
> 	}
> }
> ```
>
> ​     <생성자와 메소드의 차이 >
>
> - 상속이 되지 않으며, 오버라이딩의 대상이 될 수 없다.
>
> - 메소드와 호출 방식이 다르다.
>
> - 생성자는 클래스의 이름과 같아야 하며, 반환형이 없다. 또한 void표기가 필요 없다.
>
>   <생성자를 쓰는 이유>
>
> - 인스턴스(객체)가 생성될 때 수행되어야 하는 작업이 있기 때문이다. 즉, 필드에 초기값을 (지정)저장 하거나 메소드(작업)를 호출하여 객체(인스턴스) 사용 전에 필요한 준비를 한다고 보면 된다
