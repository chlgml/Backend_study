## controller(3)

```java
	 @GetMapping 
    public PostsResponse getPosts() {
        // PostsResponse 클래스 타입으로 반환
        return postService.getPosts();
        	// postService를 호출했지만 인터페이스이므로 postService를 상속받은 PostServiceImpl가 실행된다.
         	com.example1.demo.service;
        		@Override 
    		public PostsResponse getPosts() {
     	   List<Post> postList = postRepository.findAllBy();
                // post 타입으로 List를 생성함. 리스트 안에는 Repository에서 모든 레코드를 불러왔음
     	   List<Posts> posts = new ArrayList<>();
                // Posts 타입으로 List를 생성함. ArrayList방식으로 생성함!
                
      		  for (Post post : postList) {
             	    //for each문 형식
    				//for(변수타입 변수이름 : 배열이름) 배열의 학목 수 만큼 실행부분을 반복해줌.
       		     posts.add(
                     // .add는 List의 추가 기능임!
         	           Posts.builder() // 빌더 패턴을 통해서 post의 값을 Posts속에 저장함
                            .id(post.getId())
                            .title(post.getTitle())
                            .build()
          				  );
      		  }

       		 return PostsResponse.builder()
            				    .posts(posts)
               					 .build();
                	// 찾은 값을 DTO 클래스에 빌더패턴을 통해 저장해서 반환함
    }
        		
        
    }
```


***



```java
@GetMapping("/{id}")
    public PostResponse getDetailPost(@PathVariable Integer id) {
        return postService.getDetailPost(id);
        		package com.example1.demo.service;
        		@Override 
    			public PostResponse getDetailPost(Integer id) {
        			Post post= postRepository.findById(id) 
                        		// Post 타입으로 Repository에서 id와 일치하는 레코드를 찾아서 저장함
                							 .orElseThrow(PostNotFoundException::new); // 예외처리

      				return PostResponse.builder()
             						   .title(post.getTitle())
                					   .content(post.getContent())
              						   .build();
    }
    }
```

