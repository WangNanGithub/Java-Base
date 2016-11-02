package com.devil.effective.concurrent.finall;

public final class Product { // final 确保无子类
    private final int id;
    private final char chs;
    private final String name;

    public Product(int id, char chs, String name) {
        this.id = id;
        this.chs = chs;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public char getChs() {
        return chs;
    }

    public String getName() {
        return name;
    }

}
