## Entity 연관관계

처음부터 말하고 가자면 실제 데이터베이스에는 양방향 관계가 없다. JPA에서 존재하는 개념이지 실제 데이터베이스는 방향이라는 개념이 없다고 한다. 

아래의 코드는 양방향 게시글:댓글 = 1:N의 관계이다. 단방향 관계는 코드 예시를 쓰지 않음.



게시글

```java
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post") // 연관관계가 양방향일 경우 존재, "post"은 댓글 Entity의 자기 필드를 가르킴
    private List<Comment> comment; // 매핑한 Entity가 n개라면 List로!

    @Builder
    public Post (String name, String title, String content) {
        this.name = name;
        this.title = title;
        this.content = content;
    }

}
```



댓글

``` java
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String comment;

    @ManyToOne // 매핑할 방식에 따라 어노테이션이 달라진다
    @JoinColumn(name = "postId") // 외래키를 가지고 있는 주인 Entity의 경우에는 이 어노테이션을 사용한다.
    private Post post; // mappedBy에서 가르키는 필드

    @Builder
    public Comment (String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

}
```



- 단방향이면 @JoinColumn()하고, 양방향이면 @JoinColumn()은 그대로 하고 연관된 Entity에 하나의 필드를 추가해서 연관관계 어노테이션을 붙이고 (mappedBy = "")을 추가 할 것

- 1:1매핑을 한 post와 comment라는 두개의 entity가 있다. post에서 comment의 관계에서 comment가 외래키를 가지고 있다면, post에서는  comment를 조회하거나 post가 삭제되면 comment가 삭제 되도록 해야한다면 1:1양방향 매핑을 해줘야 한다.
  - 연관관계의 주인만이 데이터베이스 연관관계와 매핑되고 외래 키를 관리(등록, 수정, 삭제)할 수 있다. 반면에 주인이 아닌 쪽은 읽기만 할 수 있다.
  - 연관관계의 주인 : 외래키를 가지고 있는 쪽이다.

- @JoinColumn이 있는 쪽이 외래키를 가지고 있는 쪽이고,  mappedBy가 있는 부분이 외래키를 가지지 못한 쪽이다. 
  -  @JoinColumn의 name은 매핑할 entity의 id와 상관 없는 컬럼 이름이다...
  - mappedBy에서 지정하는 것은 연관관계 주인 테이블의 나의 필드다. 얘가 나라는 것을 알려준다고 생각하면 편하다.
- 연관관계에서는 1:N 또는 N:1의 관계에서는 항상 N쪽만이 외래키를 가진다. 그러므로 @ManyToOne에서는 항상 연관관계의 주인이 되므로 mappedBy속성이 없다.



## DB 연관관계

Entity끼리는 연관관계를 맺을 수 있는데 이를 '관계형 데이터베이스'라고 한다.

- 1:1(일대일) 관계
  일대일 관계는 하나의 Entity는 연관된  Entity와 단 하나의 관계를 맺는 것을 말한다.
  예) 학생 - 성적

- 1:N(일대다) 관계
  일대다 관계는 하나의 Entity가 연관된 Entity의 객체를 여러개를 가질 수 있는 것을 말한다.
  예) 반 - 학생
  -> 보충 설명을 하자면 Entity를 가질 수 있는 것이 아니라 연관된 Entity의 '객체'를 가질 수 있는 것이다.
     1반 이라는 하나의 Entity에 여러명의 학생이 학생 Entity에서 객체로 생성되어 연관된다.

- N:N(다대다)관계
  다대다 관계는 두 Entity모두 여러개의 객체를 가지고 있는 것이다. 주 Entity도 연관된 Entity도 서로의 객체가 연관되어있다.
  -> 여기서 1:N이랑 N:N이 헷갈리는데 그림을 그리면 바로 이해가 된다. 1:N은 한쪽만 많은 것이라고 생각하면 된다.
     딱 한쪽만 많이 연관된것이다. 근데 N:N은 둘다 많은 객체를 가지고 있는 것이다.
     1:N에서 예로 든 반 - 학생을 통해 설명하자면 학생은 1반 말고 다른 반을 가질 수 없기 때문에 N:N관계가 될 수 없다.
  예)  학원 - 학생 (학생은 많은 학원을 다닐 수 있으며, 학원은 많은 학생을 수용한다)
