package com.li.Demo1;

public class 中介 implements Rent {
    private 房东 host;

    public 中介(房东 host) {
        this.host = host;
    }

    public void rent() {
        findHouse();
        money();
        paper();
        System.out.println("中介出租房东的房");
    }

    public void findHouse() {
        System.out.println("带你看房");
    }

    public void money() {
        System.out.println("交钱");
    }
    public void paper() {
        System.out.println("签订契约");
    }
}
