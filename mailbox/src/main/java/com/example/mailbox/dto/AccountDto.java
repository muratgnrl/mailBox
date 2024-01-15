package com.example.mailbox.dto;

import com.example.mailbox.model.Account;
import com.example.mailbox.model.Message;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

public class AccountDto implements Serializable {

    public int accountId;
    public int userId;
    public List<Message> messageList;

    public AccountDto accountToDto(Account account){
        AccountDto accountDto=new AccountDto();
        accountDto.accountId=account.getAccountId();
        accountDto.messageList=account.getMessageList();
        accountDto.userId=account.getUserId();
        return accountDto;
    }
}
