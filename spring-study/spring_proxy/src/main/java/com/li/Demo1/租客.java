package com.li.Demo1;

public class 租客 {
    public static void main(String[] args) {
        中介 proxy = new 中介(new 房东());
        proxy.rent();

    }
}
