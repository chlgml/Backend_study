## 지양해야하는 lombok

### @Setter

Setter는 객체를 언제든지 변경할 수 있도록 하기 때문에 객체의 안전성을 보장받지 못한다. Entity에서 @Setter을 사용하게 되면 어디서 누구의 의해 수정되었는 지 알 수 없기 때문에 값 변경이 필요한 경우에는 의미있는 메서드를 생성하여 이를 사용하는 것이 좋다.

### @NoArgsConstructor

기본 생성자를 생성하는 @NoArgsConstructor 어노테이션의 접근 제어를 PROCTECTED로 설정하게 되면 아무런 값도 갖지 않는 의밍 없는 객체의 생성을 막아준다. -> 무분별한 객체 생성을 막아줄 수 있다.

#### @AllArgsConstructor 

@Builder를 생성할 때 클래스 위에 붙이거나 생성자에 붙여주는 방법이 있다. 클래스 위에 붙여서 사용할 때, @NoArgsConstructor가 있는 클래스에 @Builder를 사용하게 된다면 오류가 난다. 그래서 모든 필드를 가지는 생성자를 생성해주는 @AllArgsConstructor를 붙여 사용하는데 @AllArgsConstructor 를 사용하면 인스턴스 멤버의 선언 순서에 영향을 받기 때문에 두 변수의 순서를 바꾸면 생성자의 입력 값의 순서도 바뀌게 되어 발견되지 않는 치명적 오류를 발생시킬 수 있기 때문에 따로 생성자를 만들어서 @Builder를 적용해서 사용해야 한다.