package com.xmu.middleware.webchat2018.dao;


import java.math.BigInteger;
import java.util.List;


import org.apache.ibatis.annotations.Param;
public interface FriendsMapper {
    List<BigInteger> listFriendsIdByUserId(@Param("userId") BigInteger userId);

}