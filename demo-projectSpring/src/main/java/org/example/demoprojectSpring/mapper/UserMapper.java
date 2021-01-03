package org.example.demoprojectSpring.mapper;

import org.example.demoprojectSpring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jack", new User(1, "jack", "123"));
        userMap.put("laowang", new User(2, "laowang", "321"));
        userMap.put("xiaoli", new User(3, "xiaoli", "567"));
    }

    public List<User> listUser() {
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }

    public User login(String username, String password) {
        User user = userMap.get(username);
        if(user == null) {
            return null;
        }
        if(password!= null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}
