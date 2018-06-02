package com.xmu.middleware.webchat2018.controller;

import com.xmu.middleware.webchat2018.controller.vo.ResponseVO;
import com.xmu.middleware.webchat2018.dao.FriendsMapper;
import com.xmu.middleware.webchat2018.dao.UserMapper;
import com.xmu.middleware.webchat2018.exception.UserNotFoundException;
import com.xmu.middleware.webchat2018.model.ContactHistory;
import com.xmu.middleware.webchat2018.model.User;
import com.xmu.middleware.webchat2018.servcie.FriendsService;
import com.xmu.middleware.webchat2018.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FriendsService friendsService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpSession session) throws UserNotFoundException {
        User user = null;
        user = userService.login(username, password);
        if (user == null) {
            System.out.println("登录失败");
            ResponseVO responseVO = new ResponseVO(401, "/login.html", user);

        } else {
            user.setPassword("");
        }
        ResponseVO responseVO = new ResponseVO(200, "/chat.html", user);
        System.out.println(responseVO.toString());
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON_UTF8).body(responseVO);
    }

    @GetMapping(value = "/me/listRecentContact")
    public ResponseEntity<List<User>> listFrinds(@RequestParam("id") Integer id) {
        List<User> result = new ArrayList<>();
        result = friendsService.ListFriends(BigInteger.valueOf(id));
        if (result.isEmpty()) {
            System.out.println("没有好友");
            return null;
        } else
            System.out.println("好友列表" + result);
        return new ResponseEntity<List<User>>(result, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/me/listRecentChatMessage")
    public ResponseEntity<List<ContactHistory>> listRecentChatMessage(@RequestParam("username") String username, @RequestParam("friendname") String friend_name) {
        System.out.println(username + friend_name);
        List<ContactHistory> contactHistories = new ArrayList<>();
        contactHistories = userService.listContactHistory(username, friend_name);
        Collections.sort(contactHistories);
        return new ResponseEntity<List<ContactHistory>>(contactHistories, new HttpHeaders(), HttpStatus.OK);
    }
}
