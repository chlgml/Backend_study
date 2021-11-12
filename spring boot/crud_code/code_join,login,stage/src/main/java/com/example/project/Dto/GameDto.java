package com.example.project.Dto;

import com.example.project.Entity.GameEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class GameDto {

    @NotBlank
    private Integer Sstage;

    @NotBlank
    private Integer Cstage;

    @NotBlank
    private Integer Jstage;

    public GameEntity toEntity() {
        GameEntity gameEntity = GameEntity.builder()
                .Sstage(Sstage)
                .Cstage(Cstage)
                .Jstage(Jstage)
                .build();
        return gameEntity;
    }

    @Builder
    public GameDto(Integer Sstage, Integer Cstage, Integer Jstage){
        this.Sstage = Sstage;
        this.Cstage = Cstage;
        this.Jstage = Jstage;
    }

}
