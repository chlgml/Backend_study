package com.example.password.Controller;

import com.example.password.Dto.Dto;
import com.example.password.Service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final Service service;

    @PostMapping("/seve")
    @ResponseStatus(HttpStatus.CREATED)
    public void seve(@Valid @RequestBody Dto dto) {
        service.seve(dto);
    }

    @GetMapping("/vrfct")
    @ResponseStatus(HttpStatus.OK)
    public void vrfct(@Valid @RequestBody Dto dto) {
        service.vrfct(dto);
    }

}
