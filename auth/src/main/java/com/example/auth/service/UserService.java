package com.example.auth.service;

import com.example.auth.api.AccountCallableApi;
import com.example.auth.dto.UserDto;
import com.example.auth.entity.User;
import com.example.auth.exception.FindException;
import com.example.auth.exception.RegisterException;
import com.example.auth.exception.UserAlreadyException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.repository.UserRepository;
import com.example.auth.response.CreateAccountResponse;
import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.hibernate.annotations.processing.Find;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountCallableApi accountCallableApi;

    public UserService(UserRepository userRepository, AccountCallableApi accountCallableApi) {
        this.userRepository = userRepository;
        this.accountCallableApi = accountCallableApi;
    }

    public UserResponse register(UserDto userDto)throws UserAlreadyException,RegisterException {


       User existingUser=userRepository.findUserByMail(userDto.mail);
       if (existingUser!=null){
           throw new UserAlreadyException();
        }

       User user=User.fromResource(userDto);
       user=userRepository.save(user);
       userDto.userId=user.getUserId();
       CreateAccountResponse accountResponse= accountCallableApi.createMailBox(userDto);
       if (accountResponse.meta.errorCode!=200){


           throw new RegisterException();
       }
       return createdUser(User.toResource(user));

    }

    public UserResponse login(UserDto userDto) throws UserLoginException{
        User user=userRepository.findUserByMailAndPassword(userDto.mail,userDto.password);
        if (user==null){
            throw new UserLoginException();
        }
        return createdUser(User.toResource(user));
    }
    private UserResponse createdUser(UserDto toResourse) {
        UserResponse userResponse = new UserResponse();
        userResponse.meta=new Meta(200);
        userResponse.userDto = toResourse;
        return userResponse;
    }

    public UserDto findUserByDto(int userId) throws FindException {
        User user=findUser(userId);
        if (user!=null){
            throw new FindException();
        }
        UserDto userDto=User.toResource(user);
        return userDto;
    }

    private User findUser(int userId) throws FindException {
        User user = userRepository.findUserByUserId(userId);
            return user;
        }

}
