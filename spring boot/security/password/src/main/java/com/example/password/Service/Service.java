package com.example.password.Service;

import com.example.password.Dto.Dto;
import com.example.password.Entity.Entity;
import com.example.password.Entity.Repository;
import com.example.password.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final Repository Repository;

    public void seve(Dto dto) {

        Entity entity = Entity.builder()
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
                // 비밀번호를 암호화
                .build();

        Repository.save(entity);

    }

    public void vrfct(Dto dto) {

        Entity Entity = Repository.findByName(dto.getName())
                .orElseThrow(NotFoundException::new);

        if(!passwordEncoder.matches(dto.getPassword(), Entity.getPassword())) {
            // matches(비교할 비밀번호, db에 저장되어 있는 비밀번호)
            throw new NotFoundException();
        }

    }

}
