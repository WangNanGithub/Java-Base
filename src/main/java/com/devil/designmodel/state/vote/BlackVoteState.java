package com.devil.designmodel.state.vote;

/**
 * 具体状态类——黑名单
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }

}