## 페이징(Paging) 처리



```java
// Controller
 public PostListResponse ShowPost(Pageable page) {
     							// controller에서 page 변수를 받아옴
        return showPostService.showpost(page);
    }

// Service
public PostListResponse showmain(Pageable page) {
	Page<Post> postEntityList = postRepository.findAllByOrderByIdDesc(page);
    									// Repository에 넘겨주면 페이징 처리를 해서 넘겨준다!!
	return list(postEntityList);
}
```

파라미터에 size=한 페이지에 넣을 객체의 수, page =현재 페이지 이런식으로 보내면 그에 맞게 잘라서 보내준다.

예를 들어  size=2, page =1 이라고 보낸다면 아래의 형식으로 보내지게 된다.

```json
{
    post [
    	{
    	"id" : 1,
    	"title" : "제목1",
    	"content": "내용1",
    	"writer": "최희"
		},
		{
    	"id" : 1,
    	"title" : "제목2",
    	"content": "내용2",
    	"writer": "최희"
		}
    ]
}
```
