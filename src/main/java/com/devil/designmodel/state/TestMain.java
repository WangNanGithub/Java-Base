package com.devil.designmodel.state;

public class TestMain {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.handle();
        tree.handle();
        tree.handle();
        tree.handle();

        Tree tree2 = new Tree();
        tree2.handle();
        System.out.println("一场大火");
        tree2.setState(new DeathState(tree2));
        tree2.handle();

    }
}
