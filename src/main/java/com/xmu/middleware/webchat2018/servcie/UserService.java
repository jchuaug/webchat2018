package com.xmu.middleware.webchat2018.servcie;

import com.xmu.middleware.webchat2018.dao.ContactHistoryMapper;
import com.xmu.middleware.webchat2018.dao.UserMapper;
import com.xmu.middleware.webchat2018.exception.UserNotFoundException;
import com.xmu.middleware.webchat2018.model.ContactHistory;
import com.xmu.middleware.webchat2018.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ContactHistoryMapper contactHistoryMapper;

    public User login(String username,String password) throws UserNotFoundException {
        User user=null;
        user=userMapper.getUserByName(username);
        if(user==null){
            throw new UserNotFoundException("用户不存在");
        }else{
            return user;
        }

    }


    public List<ContactHistory>listContactHistory(String username,String friend_name){
        List<ContactHistory>listContactHistories=contactHistoryMapper.listContactHistory(username,friend_name);
        return  listContactHistories;

    }
}
