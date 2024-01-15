package com.example.auth.entity;

import com.example.auth.dto.UserDto;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String userLastName;
    @Column(unique = true)
    private String mail;
    private String password;


    public static User fromResource(UserDto userDto){
        User user=new User();
        user.setMail(userDto.mail);
        user.setUserId(userDto.userId);
        user.setUserName(userDto.userName);
        user.setUserLastName(userDto.userLastName);
        user.setPassword(userDto.password);
        return user;
    }
    public static UserDto toResource(User user){
        UserDto userdto=new UserDto();
        userdto.mail=user.mail;
        userdto.userName=user.userName;
        userdto.userId=user.userId;
        userdto.userLastName=user.userLastName;
        userdto.password= user.password;
        return userdto;

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public User() {
    }

    public User(int userId, String userName, String userLastName, String mail, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.mail = mail;
        this.password = password;
    }
}
