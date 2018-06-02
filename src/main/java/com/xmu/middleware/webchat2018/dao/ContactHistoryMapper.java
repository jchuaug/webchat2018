package com.xmu.middleware.webchat2018.dao;

import com.xmu.middleware.webchat2018.model.ContactHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactHistoryMapper {
    List<ContactHistory> listContactHistory(@Param("username") String username, @Param("friend_name") String friend_name);

    void insertHistory(ContactHistory contactHistory);
}
