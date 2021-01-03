package org.example.demoprojectSpring.serivce;

import org.example.demoprojectSpring.domain.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    String login(String username, String password);
}
