package com.example.project.Dto;

import com.example.project.Entity.UserEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String pwd;

    private GameDto gameDto;

    public UserEntity toEntity() {
        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .pwd(pwd)
                .build();
        return userEntity;
    }

    @Builder
    public UserDto(String name, String pwd, GameDto gameDto){
        this.name = name;
        this.pwd = pwd;
        this.gameDto = gameDto;
    }

}
