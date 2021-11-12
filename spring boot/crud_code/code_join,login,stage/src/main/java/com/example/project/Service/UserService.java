package com.example.project.Service;

import com.example.project.Dto.GameDto;
import com.example.project.Dto.UserDto;
import com.example.project.Entity.GameEntity;
import com.example.project.Entity.UserEntity;
import com.example.project.Entity.UserRepository;
import com.example.project.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 회원가입시 회원정보 저장
    public UserEntity seveData(UserDto userdto){

        UserEntity userEntity = UserEntity.builder()
                .name(userdto.getName())
                .pwd(userdto.getPwd())
                .gameEntity(
                        GameEntity.builder()
                                .Jstage(0)
                                .Cstage(0)
                                .Sstage(0)
                                .build()
                )
                .build();

        return userRepository.save(userEntity);

    }

    // 로그인시 입력한 데이터가 있는지 확인
    public void find(UserDto userdto) throws NotActiveException {
        userRepository.findByname(userdto.getName())
                .filter(userEntity -> userEntity.getPwd().equals(userdto.getPwd()))
                .orElseThrow(NotFoundException::new);
    }

    // 사용자 아이디에 맞는 game data를 반환
    public UserDto gameData(UserDto userdto) {
        // 사용자 name을 통해 레코드 찾기
        UserEntity userEntity = userRepository.findByname(userdto.getName())
                .orElseThrow(NotFoundException::new);

        UserDto userDto = UserDto.builder()
                .name(userEntity.getName())
                .pwd(userEntity.getPwd())
                .gameDto(
                        GameDto.builder()
                                .Sstage(userEntity.getGameEntity().getSstage())
                                .Cstage(userEntity.getGameEntity().getCstage())
                                .Jstage(userEntity.getGameEntity().getJstage())
                                .build()
                )
                .build();

        return userDto;
    }

}
