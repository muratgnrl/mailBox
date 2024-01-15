package com.example.mailbox.service;

import com.example.mailbox.dto.UserDto;
import com.example.mailbox.model.Account;
import com.example.mailbox.repo.AccountRepository;
import com.example.mailbox.response.CreateAccountResponse;
import com.example.mailbox.response.Meta;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public CreateAccountResponse createMailBox(UserDto userDto) {
        CreateAccountResponse createAccountResponse=new CreateAccountResponse();
        Meta meta=new Meta(200);
        meta.errorCode=200;
        Account account=new Account();
        account.setUserId(userDto.userId);
        account=accountRepository.save(account);
        if (account==null){
            meta.errorCode=3001;
        }
        createAccountResponse.meta=meta;
        return createAccountResponse;
    }

    public Account findAccount(int userId) {
        return accountRepository.findByUserId(userId);
    }
}
