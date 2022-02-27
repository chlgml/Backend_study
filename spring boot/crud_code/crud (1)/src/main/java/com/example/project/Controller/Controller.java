package com.example.project.Controller;

import com.example.project.Dto.UserDto;
import com.example.project.Service.GameService;
import com.example.project.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.NotActiveException;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final UserService userService;
    private final GameService gameService;

    // 회원가입
    @PostMapping("/join")
    @ResponseStatus (HttpStatus.CREATED) // 201
    public void join (@RequestBody @Valid UserDto dto) {
        userService.seveData(dto);
    }
                                // @Valid를 붙이지 않으면 @NotBlank을 체크하지 못함.

    // 로그인
    @PostMapping("/login")
    @ResponseStatus (HttpStatus.CREATED) // 201
    public UserDto login(@RequestBody @Valid UserDto userdto) throws NotActiveException {
        userService.find(userdto);
        return userService.gameData(userdto);
    }

    // 아이디 중복 체크
    @GetMapping("/login/{name}/exists")
    @ResponseStatus (HttpStatus.OK) // 200
    private void exists(@PathVariable String name) {
        userService.exists(name);
    }

    // 스도쿠
    @GetMapping("/S/{name}/{Sstage}")
    @ResponseStatus (HttpStatus.OK) // 200
    public void Sstage (@PathVariable("name")String name,
                       @PathVariable("Sstage")Integer Sstage) {
        gameService.saveSstage(name, Sstage);
    }

    // 카드
    @GetMapping("/C/{name}/{Cstage}")
    @ResponseStatus (HttpStatus.OK) // 200
    public void Cstage (@PathVariable("name")String name,
                       @PathVariable("Cstage")Integer Cstage) {
        gameService.saveCstage(name, Cstage);
    }

    // 지뢰찾기
    @GetMapping("/J/{name}/{Jstage}")
    @ResponseStatus (HttpStatus.OK) // 200
    public void Jstage (@PathVariable("name")String name,
                        @PathVariable("Jstage")Integer Jstage) {
        gameService.saveJstage(name, Jstage);
    }


}
