package com.xmu.middleware.webchat2018;

import com.xmu.middleware.webchat2018.dao.UserMapper;
import com.xmu.middleware.webchat2018.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {
//    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUserByName() {
        String username="jackey";
       System.out.println(userMapper.getUserByName(username));
    }

}
