package com.example.password.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

}
