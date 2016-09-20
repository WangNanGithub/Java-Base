package com.devil.designmodel.state;

/**
 * 生长状态
 */
public class GrowState implements TreeState {

    private Tree tree;

    public GrowState(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void handle() {
        System.out.println("植物长大");
        tree.setState(tree.states.get("fruit"));
    }

}
