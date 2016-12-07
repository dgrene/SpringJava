package com.kumard.repository;

import com.kumard.model.Reward;

import java.sql.SQLException;
import java.util.List;


public interface RewardRepository {

    void addReward(Reward reward) throws SQLException;

    int getTotalRewardAmount(Long accountNumber) throws SQLException;

    List<Reward> getAllRewardsForAccount(Long accountNUmber) throws SQLException;


}
