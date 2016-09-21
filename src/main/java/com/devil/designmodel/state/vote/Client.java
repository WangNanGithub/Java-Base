package com.devil.designmodel.state.vote;

/**
 * 客户端类
 */
public class Client {

    /**
     * 测试用例，同一个用户，对同个选项进行多次投票
     *
     */
    public static void main(String[] args) { 
        
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 9; i++) {
            vm.vote("u1", "A");
        }
        
        for (int i = 0; i < 9; i++) {
            vm.vote("u2", "A");
        }
    }

}