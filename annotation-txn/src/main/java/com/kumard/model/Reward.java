package com.kumard.model;

/**
 * Created by deepak on 4/12/16.
 */
public class Reward {
    private Long rewardConfirmationNumber;
    private int rewardAmount;
    private Long accountNumber;

    public Long getRewardConfirmationNumber() {
        return rewardConfirmationNumber;
    }

    public void setRewardConfirmationNumber(Long rewardConfirmationNumber) {
        this.rewardConfirmationNumber = rewardConfirmationNumber;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
