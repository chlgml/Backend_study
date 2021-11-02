package com.example1.demo.controller;

import com.example1.demo.payload.PostRequest;
import com.example1.demo.payload.PostResponse;
import com.example1.demo.payload.PostsResponse;
import com.example1.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 추가한다.
@RequestMapping("/board") // 요청 URL을 어떤 메소드가 처리할지 매핑해준다. 요청 받는 방식을 정의하기도 한다.
@RestController // @Controller + @ResponseBody , @ResponseBody를 붙이지 않아도 문자열과 JSON을 전송할 수 있음
// @Controller : 이 어노테이션이 적용된 클래스는 Controller인 거을 나타내고 bean으로 등록되며 해당 클래스가 Controller로 사용됨.
// Controller : 인스턴스의 생면 주기 관리, 생성된 인스턴스들에게 추가적인 기능 제공
// bean : Spring Container에서 생성되는 객체
// @ResponseBody : 자바 객체를 HTTP 응답 몸체로 변환
public class Controller {

    private final PostService postService;

    @PostMapping // @RequestMapping(Method=RequestMethod.Post)과 같다.
    // 위에서 @RequestMapping 의 요청받는 방식을 정의하는 것과 비슷한 원리 어떤 요청을 처리할것인지 말하는 것. 여기서는 Post임.
    // @GetMapping, @PutMapping, @PatchMapping, @DeleteMapping 등 도 있다.
    @ResponseStatus //
            (HttpStatus.CREATED)
    public void writePost(@RequestBody @Valid PostRequest request) {
        postService.writePost(request);
    }

    @GetMapping // @RequestMapping(Method=RequestMethod.GET)과 같다.
    // 위에서 @RequestMapping 의 요청받는 방식을 정의하는 것과 비슷한 원리 어떤 요청을 처리할것인지 말하는 것. 여기서는 Get임.
    // @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping 등 도 있다.
    public PostsResponse getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}") // @RequestMapping(Method=RequestMethod.GET)과 같다.
    // 위에서 @RequestMapping 의 요청받는 방식을 정의하는 것과 비슷한 원리 어떤 요청을 처리할것인지 말하는 것. 여기서는 Get임.
    // @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping 등 도 있다.
    public PostResponse getDetailPost(@PathVariable Integer id) {
        return postService.getDetailPost(id);
    }
}
