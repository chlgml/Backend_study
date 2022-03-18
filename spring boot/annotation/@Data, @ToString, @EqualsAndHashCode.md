## @Data

@Data 어노테이션 안에는 @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor이 포함되어 있다. @Data안의 포함되어 있는 어노테이션들에 대해서는 설정을 할 수 없기 때문에 기본 설정값이 아닌 값을 사용할때는 개별 어노테이션을 사용해야한다.



## @ToString

ToString() 메소드를 생성한다. @ToString(exclude={"제외할 값"})이렇게 쓰면 원하지 않는 속성을 제외 할 수 있다.



**ToString() 메소드**

객체지향 언어들은 객체에 ToString()이라는 메소드를 기본적으로 제공한다. ToString()은 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드이다. 이 메소드는 오버라이딩을 통해 재정의를 할 수 있다. 



## @EqualsAndHashCode

equlas와 hashcode 메소드를 만들어 준다.  
hashcode와 equlas의 자세한 설명은 단어를 누르면 나온다. 

