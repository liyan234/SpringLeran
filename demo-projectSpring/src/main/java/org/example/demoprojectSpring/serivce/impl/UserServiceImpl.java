package org.example.demoprojectSpring.serivce.impl;

import org.example.demoprojectSpring.domain.User;
import org.example.demoprojectSpring.mapper.UserMapper;
import org.example.demoprojectSpring.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    public static Map<String, User> sessionMap = new HashMap<>();


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
      return userMapper.listUser();
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username, password);
        if(user == null) {
            return null;
        } else {
            // 生成一个sessionID
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token, user);
            return token;
        }
    }
}
