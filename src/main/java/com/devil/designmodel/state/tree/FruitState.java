package com.devil.designmodel.state.tree;

/**
 * 结果状态
 */
public class FruitState implements TreeState {

    private Tree tree;

    public FruitState(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void handle() {
        if (tree.now < (tree.growSize + tree.fruitSize)) {
            System.out.println("植物结果");
            tree.now++;
        } else {
            tree.setState(tree.states.get("death"));
        }
    }

}
