package com.xmu.middleware.webchat2018.servcie;

import com.xmu.middleware.webchat2018.dao.FriendsMapper;
import com.xmu.middleware.webchat2018.dao.UserMapper;
import com.xmu.middleware.webchat2018.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FriendsMapper friendsMapper;

    public List<User> ListFriends(BigInteger userId){
        List<User> result=new ArrayList<>();
        List<BigInteger> friends_id=friendsMapper.listFriendsIdByUserId(userId);
        for (BigInteger id :friends_id) {
            result.add(userMapper.getUserById(id));
        }
        return result;
    }
}
