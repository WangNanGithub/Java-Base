package com.devil.designmodel.state.tree;

/**
 * 死亡
 */
public class DeathState implements TreeState {
    private Tree tree;

    public DeathState(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void handle() {
        System.out.println("植物已死亡");
        tree.setState(tree.states.get("death"));
    }
}
