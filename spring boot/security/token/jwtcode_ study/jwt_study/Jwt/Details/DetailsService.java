package com.example.jwt_study.Jwt.Details;

import com.example.jwt_study.Entity.Account.AccountRepository;
import com.example.jwt_study.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public Details loadUserByUsername(String id) throws UsernameNotFoundException {

        return accountRepository.findByAccountId(id)
                .map(Details::new)
                .orElseThrow(NotFoundException::new);
    }

}
