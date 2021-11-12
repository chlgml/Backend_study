package com.example.project.Service;

import com.example.project.Entity.GameEntity;
import com.example.project.Entity.UserEntity;
import com.example.project.Entity.UserRepository;
import com.example.project.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameService {

    private final UserRepository userRepository;

    // URL을 통해 전송된 game의 stage data를 해당 아이디 테이블과 연결되어 있는 게임 테이블에 저장
    // 스토쿠 게임의 stage data를 저장
    public void saveSstage(String name, Integer Sstage)throws NotFoundException {

        // 사용자 name을 통해 레코드 찾기
        UserEntity userEntity = userRepository.findByname(name)
                .orElseThrow(NotFoundException::new);

        UserEntity userDto = UserEntity.builder()
                .id(userEntity.getId())
                // 해당 id값을 넘겨주지 않으면 새로운 레코드가 생성되니 유의할 것!
                .name(userEntity.getName())
                .pwd(userEntity.getPwd())
                .gameEntity(
                        GameEntity.builder()
                                .id(userEntity.getGameEntity().getId())
                                .Cstage(userEntity.getGameEntity().getCstage())
                                .Jstage(userEntity.getGameEntity().getJstage())
                                .Sstage(Sstage)
                                .build()
                )
                .build();

        userRepository.save(userDto);
    }

    // 카드 게임의 stage data를 저장
    public void saveCstage(String name, Integer Cstage)throws NotFoundException {

        UserEntity userEntity = userRepository.findByname(name)
                .orElseThrow(NotFoundException::new);

        UserEntity userDto = UserEntity.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .pwd(userEntity.getPwd())
                .gameEntity(
                        GameEntity.builder()
                                .id(userEntity.getGameEntity().getId())
                                .Sstage(userEntity.getGameEntity().getSstage())
                                .Jstage(userEntity.getGameEntity().getJstage())
                                .Cstage(Cstage)
                                .build()
                )
                .build();

        userRepository.save(userDto);

    }

    // 지뢰 찾기의 stage data를 저장
    public void saveJstage(String name, Integer Jstage)throws NotFoundException {

        UserEntity userEntity = userRepository.findByname(name)
                .orElseThrow(NotFoundException::new);

        UserEntity userDto = UserEntity.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .pwd(userEntity.getPwd())
                .gameEntity(
                        GameEntity.builder()
                                .id(userEntity.getGameEntity().getId())
                                .Cstage(userEntity.getGameEntity().getCstage())
                                .Sstage(userEntity.getGameEntity().getSstage())
                                .Jstage(Jstage)
                                .build()
                )
                .build();

        userRepository.save(userDto);

    }

}
