package com.devil.designmodel.state.vote;

/**
 * 客户端类
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class Client {

    /**
     * 测试用例，同一个用户，对同个选项进行多次投票
     *
     * @param 
     * @return 
     * @throws 
     * @author yuansheng
     * @version 1.0.0
     */
    public static void main(String[] args) { 
        
        VoteManager vm = new VoteManager();
        for (int i = 0; i < 9; i++) {
            vm.vote("u1", "A");
        }
    }

}