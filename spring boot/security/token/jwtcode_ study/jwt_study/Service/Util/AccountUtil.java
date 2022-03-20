package com.example.jwt_study.Service.Util;

import com.example.jwt_study.Entity.Account.Account;
import com.example.jwt_study.Entity.Account.AccountRepository;
import com.example.jwt_study.Exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountUtil {

    private final AccountRepository accountRepository;
    private final AuthenticationUtil authenticationUtil;

    public Account getAccount() {
        return accountRepository.findByAccountId(authenticationUtil.getAccountId())
                .orElseThrow(NotFoundException::new);
    }

}
