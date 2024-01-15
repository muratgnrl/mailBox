package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.FindException;
import com.example.auth.exception.RegisterException;
import com.example.auth.exception.UserAlreadyException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControl {

    private final UserService userService;

    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public UserResponse register(@RequestBody UserDto userDto)throws UserAlreadyException, RegisterException {
        return userService.register(userDto);
    }

    @PostMapping("login")
    public UserResponse login(@RequestBody UserDto userDto)throws UserLoginException {
        return userService.login(userDto);
    }
    @GetMapping("/find/{userId}")
    public UserDto findUser(@PathVariable(value = "userId") int userId)throws FindException {
        return userService.findUserByDto(userId);
    }
}
