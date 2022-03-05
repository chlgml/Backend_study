## 객체 지향 프로그래밍(OOP)

객체의 관점에서 프로그래밍 하는 것으로, C언어는 절차지향으로 함수를 차례로 읽고 실행하는 것이라고 하면 자바는 객체 지향으로 객체를 연결하여 실행하는 것이라고 보면 된다.



### 1. 추상화

*******************

객체들의 공통된 특징을 파악해 묶어놓는 설계 기법

ex) 자동차는 여러 브랜드의 차가 있지만, 공통적인 행위들이 있는 데 이를 묶어 놓는 것을 말

추상클래스 

- 객체 생성이 되지 않으며, 실체 클래스와 상속관계이다. 또한 시간 절약 가능

  ```java
  public abstract class 클래스명{
   // 내용   
  }
  ```



### 2. 캡슐화

*************

- 객체의 필드와 메소들을 하나로 묶는다.

- 정보 은닉을 할 수 있다는 장점이 있으며, 접근 제한자를 통해 불필요한 정보를 감출수 있다. (외부에서 접근 할 수 없도록 함)

  ```
  캡슐화는 정보은닉과 동일한 개념이 아니다. 캡슐화를 하면 정보를 감출 수 있기 때문에 정보 은닉을 할 수 있다는 특징을 가지고 있는 것이다.
  ```

외부의 접근이로부터 보호된 필드는 setter와 getter를 통해 간접적으로 접근이 가능하다.

getter은 수정,  setter은 불러오기라고 볼 수 있음

```java
public class point {
	public int xpos;
	public int ypos;
}

// 위의 코드를 getter을 이용하여 바꾼 코드 
public class point {
	private int xpos;
	// 여기서 접근 제한자는 private를 쓴다.
	// 접근이 클래스 내부밖에 안되서 은닉화를 할 수 있음.
	private int ypos;

	public int getWidth() {
  	 // 직접 수정하는 것이 아닌 getter을 이용해서 수정
	   return xpos;
	}

	public int getHeight() {
 	  return ypos;
	}
}
```

- setter, getter 어노테이션 

  - @getter : getter메소드를 생성 해준다.
  - @setter : setter메소드를 생성 해준다.



### 3. 상속

**************

일반적인 상속의 개념과 같이 상속이란 상위 클래스의 멤버를 자식 클래스가 물려받는 것을 말한다. 상속을 한다면 기존의 클래스(부모클래스)의 내용을 가져와 재사용 할 수 있으며, 기능을 추가 할 수 있다.

- 부모 클래스(상위 클래스) - 자식 클래스(하위 클래스)

- 상속은 단 하나의 부모 클래스만을 가질 수 있다.(단일 상속) 그러므로 인터페이스를 다중 상속 할 수 있도록 해놓았다.

- 부모클래스에서 상속을 받더라도 접근제한자가 private라면 자식클래스에서 접근할 수 없다.

- 상속을 사용한다면 코드의 중복을 없앨 수 있다.

- 상속

  ```java
  class 자식 클래스 이름 extend 부모 클래스 이름 {
  } //자식 클래스 선언
  ```

Object 클래스 : 부모 클래스는 한개의 자식클래스만을 가질 수 있었지만  Object 클래스는 모든 클래스에게 상속할 수 있는 조상클래스라고 할 수 있다.



### 4. 다형성

********

자식 클래스의 타입을 부모클래스로 변경하여 자식클래스 안의 부모클래스의 내용만을 사용

- 부모클래스를 자식클래스로 타입변환 할 수는 없음.
- 자식클래스에 있는 값 참조 불가
- 만약 자식클래스에서 오버라이딩을 했다면 출력시 오버라이딩 된 결과 값 출력

```java
class Parents { //부모클래스
    int n1 = 10;
    int n2 = 20;
    public void write() {
        System.out.println("부모클래스");
    }
}

class  Child extends Parents { //자식클래스
    int n3 = 100;
    int n4 = 200;
    public void write() {
        System.out.println("자식클래스");
    }
}

class Hello {
    public static void main(String[] args) {
        Parents parents = new parents();
        Child child = new Child();
        Parents pc = new Child();
        // sp1은 Child라는 자식클래스를 Super로 생성 해 주었기 때문에
        // sp1은 Child안의 Super의 내용만을 참조할 수 있다.
        // 결국, Child의 j, z는 참조할 수 없음.
        System.out.println(pc.n3+pc.n4); // 출력 불가, 오류 발생
        System.out.println(pc.n1+pc.n2);
        // 하지만 Child안의 상속받은 x, y를 참조할 수 있음.
        pc.write();
        // Child에서 오버라이딩 된 '자식클래스'가 출력된다.
    }
}
```

- 오버로딩 : 같은 이름의 메소드를 매게변수의 개수와 타입이 다르면 재정의  =>새로운 메소드 정의

- 오버라이딩 : 부모클래스로부터 상속받은 메소드를 자식 클래스에서 재정의 => 상속받은 기존의 메소드 정의       
  - <조건> 메소드명, 리턴값, 매개변수가 같아야 함.
  - @Override : 오버라이딩이 제대로 되었는지 검사하는 어노테이션 