package com.example.project.Controller;

import com.example.project.Dto.UserDto;
import com.example.project.Service.GameService;
import com.example.project.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final UserService userService;
    private final GameService gameService;

    // 회원가입
    @PostMapping("/join")
    @ResponseStatus (HttpStatus.CREATED)
    public void join (@RequestBody UserDto dto) {
        userService.seveData(dto);
    }

    // 로그인
    @PostMapping("/login")
    @ResponseStatus (HttpStatus.CREATED)
    public UserDto login(@RequestBody UserDto userdto) throws NotActiveException {
        userService.find(userdto);
        return userService.gameData(userdto);
    }

    // 스도쿠
    @GetMapping("/S/{name}/{Sstage}")
    public void Sstage (@PathVariable("name")String name,
                       @PathVariable("Sstage")Integer Sstage) {
        gameService.saveSstage(name, Sstage);
    }

    // 카드
    @GetMapping("/C/{name}/{Cstage}")
    public void Cstage (@PathVariable("name")String name,
                       @PathVariable("Cstage")Integer Cstage) {
        gameService.saveCstage(name, Cstage);
    }

    // 지뢰찾기
    @GetMapping("/J/{name}/{Jstage}")
    public void Jstage (@PathVariable("name")String name,
                        @PathVariable("Jstage")Integer Jstage) {
        gameService.saveJstage(name, Jstage);
    }


}
