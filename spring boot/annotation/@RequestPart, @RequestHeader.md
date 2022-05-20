```java    
@PostMapping("/post")
public void SavePost(@RequestPart(value = "file", required = false) MultipartFile multipartFile
                     @RequestPart(value = "PostRequest") PostRequest postRequest) { --------- (1)

@GetMapping("/data") 
public void getHeader(@RequestHeader("HEADER") String data) { -------- (2) 

```


## (1) @RequestPart

Controller에서 File을 받을때는 MultipartFile 객체와 @RequestParam을 사용합니다. 하지만 File과 Dto를 같이 받기 위해서는 @RequestPart를 사용해야한다...!!

 
## (2) @RequestHeader

controller에서 해더로 값을 받을 때는 @RequestHeader을 사용하여 해더로 값을 받을 수 있다.