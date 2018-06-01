package com.xmu.middleware.webchat2018.dao;

import com.xmu.middleware.webchat2018.model.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

public interface UserMapper {
    User getUserByName(@Param("username") String username);

    User getUserById(@Param("id") BigInteger id);

}