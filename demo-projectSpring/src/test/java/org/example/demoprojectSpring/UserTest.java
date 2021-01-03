package org.example.demoprojectSpring;

import junit.framework.TestCase;
import org.example.demoprojectSpring.controller.UserController;
import org.example.demoprojectSpring.domain.User;
import org.example.demoprojectSpring.utils.JsonData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 底层是Junit SpringRunner专门用于我们Spring项目的单元测试
@RunWith(SpringRunner.class)
// 标记启动类，
@SpringBootTest(classes={DemoProjectSpringApplication.class})
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0, jsonData.getCode());
    }
}
