package com.li.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 相当于 <bean id="user" class="com.li.pojo.User"/>
@Component
public class User {

    public String name;

    // 相当于 <property name="name" value="1234"/>
    @Value("1234")
    public void setName(String name) {
        this.name = name;
    }
}
