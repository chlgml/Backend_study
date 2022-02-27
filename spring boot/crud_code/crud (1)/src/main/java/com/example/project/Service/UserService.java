package com.example.project.Service;

import com.example.project.Dto.GameDto;
import com.example.project.Dto.UserDto;
import com.example.project.Entity.GameEntity;
import com.example.project.Entity.UserEntity;
import com.example.project.Entity.UserRepository;
import com.example.project.Exception.ConflictException;
import com.example.project.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 회원가입시 회원정보 저장
    public UserEntity seveData(UserDto userdto){

        UserEntity userEntity = UserEntity.builder()
                .name(userdto.getName())
                .pwd(passwordEncoder.encode(userdto.getPwd()))
                    // 비밀번호를 암호화
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

        // 사용자 name을 통해 레코드 찾기
        UserEntity userEntity = userRepository.findByname(userdto.getName())
                .orElseThrow(NotFoundException::new);

        if(!passwordEncoder.matches(userdto.getPwd(), userEntity.getPwd())) {
                // matches(비교할 비밀번호, db에 저장되어 있는 비밀번호)
            throw new NotFoundException();
        }

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

    // 아이디 중복 체크
    public void exists (String name) {

        if(userRepository.existsByname(name)) {
                    // findByname은 찾을 떄 쓰고 existsByname은 비교할 때 쓴다.
                    // 아이디를 찾아서  true, false로 받으려면 existsByname을 쓰자.
            throw new ConflictException();
        }

    }

}
