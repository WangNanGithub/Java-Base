package com.devil.designmodel.state.vote;

/**
 * 具体状态类——正常投票
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 正常投票，记录到投票记录中
        voteManager.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功");
    }

}