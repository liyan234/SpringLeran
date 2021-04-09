package com.li.pojo;

public class Hello2 {

    private String name;

    public Hello2(String name) {
        this.name = name;
        System.out.println("Hello2被创建了");
        System.out.println(name);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
