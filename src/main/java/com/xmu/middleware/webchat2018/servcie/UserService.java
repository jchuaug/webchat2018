package com.xmu.middleware.webchat2018.servcie;

import com.xmu.middleware.webchat2018.dao.UserMapper;
import com.xmu.middleware.webchat2018.exception.UserNotFoundException;
import com.xmu.middleware.webchat2018.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User login(String username,String password) throws UserNotFoundException {
        User user=null;
        user=userMapper.getUserByName(username);
        if(user==null){
            throw new UserNotFoundException("用户不存在");
        }else{
            return user;
        }

    }
}
