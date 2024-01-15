package com.example.auth.repository;

import com.example.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByMail(String mail);

    User findUserByMailAndPassword(String mail, String password);


    User findUserByUserId(int userId);
}
