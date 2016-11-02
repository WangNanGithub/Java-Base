package com.devil.effective.concurrent.finall;

import org.junit.Test;

public class Main {
    @Test
    public void test() {
        Product p = new Product(2, 'b', "jhon");
        change(p);
        System.out.println(p.getId());
    }

    public void change(Product p) {
        p = new Product(1, 'a', "tomc");
    }
}
