package com.li.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class Person {
    // 如果显示定义了Autowired中的required为false 则这个属性可以为空
    @Resource(name = "cat")
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog") //指定实现的装配 Autowired和Qualifier是一套使用
    private Dog dog;
    // 这个字段可以为空
    @Nullable
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
