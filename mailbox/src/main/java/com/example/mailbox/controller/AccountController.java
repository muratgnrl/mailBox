package com.example.mailbox.controller;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.dto.UserDto;
import com.example.mailbox.response.AccountResponse;
import com.example.mailbox.response.CreateAccountResponse;
import com.example.mailbox.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
//TODO HESAP
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/create")
    public CreateAccountResponse createMailBox(@RequestBody UserDto userDto){
        return accountService.createMailBox(userDto);
    }
}
