package com.li.pojo;

//
public class Hello {
    private String name;

    public Hello() {
        System.out.println("Hello被创建了");
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
