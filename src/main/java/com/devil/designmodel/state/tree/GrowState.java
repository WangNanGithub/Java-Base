package com.devil.designmodel.state.tree;

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
        if (tree.now < tree.growSize) {
            System.out.println("植物长大");
            tree.now++;
        } else {
            tree.setState(tree.states.get("fruit"));
        }
    }

}
