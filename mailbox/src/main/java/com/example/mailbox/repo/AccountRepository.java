package com.example.mailbox.repo;

import com.example.mailbox.dto.AccountDto;
import com.example.mailbox.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUserId(int userId);
}
