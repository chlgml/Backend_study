## 지양해야하는 lombok



### @Setter

Setter는 객체를 언제든지 변경할 수 있도록 하기 때문에 객체의 안전성을 보장받지 못한다. Entity에서 @Setter을 사용하게 되면 어디서 누구의 의해 수정되었는 지 알 수 없기 때문에 값 변경이 필요한 경우에는 의미있는 메서드를 생성하여 이를 사용하는 것이 좋다.

*************

### @Data

ORM은 객체와 객체가 관계를 가지는 조합으로 테이블 간의 연관관계를 표현하게 한다. 이때 부모와 자식 객체에서 부모, 자식 객체에 @ToString를 쓴다면 부모객체에서 ToString()를 호출하면 자식 객체의 ToString()이 호출되면서 다시 부모객체의 ToString()가 호출되기 때문에 무한 반복이 되게 된다. 따라서,  include/exclude 속성을 이용해서 이를 방지해야 하지만 @Data를 쓰게 되면 설정이 불가능하기 때문에 코드가 길어져도 @Data 어노테이션을 지양하는 게 좋다.

```java
// 부모
public class Post {
    
  private String title;
  private String name;
  
  private Comment comment;
  
  @Override
  public String toString() {
    return "Post [title=" + title + ", name=" + name + ", comment=" + comment + "];
  }
}

// 자식
public class Comment {
    
  private String comment;
  private String name;
    
  private Post post;
  
  @Override
  public String toString() {
    return "Comment [comment=" + comment + ", name=" + rame + ", Post=" + post + "]";
  }
}
```

