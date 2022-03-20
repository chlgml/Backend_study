package com.example.jwt_study.Controller;

import com.example.jwt_study.Dto.AccountReqest;
import com.example.jwt_study.Dto.JwtToken;
import com.example.jwt_study.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtToken signup(@Valid @RequestBody AccountReqest reqest) {
        return authService.signup(reqest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtToken login(@Valid @RequestBody AccountReqest reqest) {
        return authService.login(reqest);
    }

    @PutMapping("/reissue")
    public JwtToken reissue(@Valid @RequestBody JwtToken jwtToken) {
        return authService.tokenRefresh(jwtToken);
    }

}
