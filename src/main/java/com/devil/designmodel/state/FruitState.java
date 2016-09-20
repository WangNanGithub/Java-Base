package com.devil.designmodel.state;

/**
 * 结果状态
 */
public class FruitState implements TreeState{

    private Tree tree;

    public FruitState(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void handle() {
        System.out.println("植物结果");
        tree.setState(tree.states.get("death"));
    }

}
