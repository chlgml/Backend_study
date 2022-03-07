## Entity_Mapping



```
아래의 코드는 양방향 게시글:댓글 = 1:N의 관계이다. 단방향 관계는 코드 예시를 쓰지 않음.
```



게시글(주인)

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

    @OneToMany(mappedBy = "comment") // 주인인 Entity에는 양방향일 경우 존재
    private List<Comment> comment = new ArrayList<>(); // 매핑한 Entity가 n개라면 List로!

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
    @JoinColumn(name = "postId") // 주인이 아닌 연결되어 있는 Entity의 경우에는 이 어노테이션을 사용한다.
    private Post post;

    @Builder
    public Comment (String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

}
```



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

단방향이면 @JoinColumn()하고, 양방향이면 @JoinColumn()은 그대로 하고 연관된 Entity에 하나의 필드를 추가해서 연관관계 어노테이션을 붙이고 (mappedBy = "")을 추가 할 것

```
1:1매핑을 한 post와 comment라는 두개의 entity가 있다. post에서 comment를 관리하고 싶을때, 즉 post가 주 테이블일때 단방향 매핑을 하려면 post가 자식 테이블이 되어야 한다. 하지만 post가 자식 테이블이 되었을 때 comment가 부모테이블이 되므로 post를 삭제해도 comment를 삭제시킬 수 없다. post가 삭제되면 comment가 삭제 되도록 해야한다면 1:1양방향 매핑을 해줘야 한다.

그리고 @JoinColumn이 있는 쪽이 자식이고 @OneToMany(mappedBy ="")이게 있는게 부모이다!! 헷갈리지 말자!! 그리고 @JoinColumn의 name은 매핑할 entity의 id와 상관 없는 컬럼 이름이다...
```