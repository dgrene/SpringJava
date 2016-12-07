package com.kumard.config;

import com.kumard.repository.*;
import com.kumard.service.BankService;
import com.kumard.service.BankServiceImpl;
import com.kumard.service.EmailService;
import com.kumard.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by deepak on 4/12/16.
 */

@Configuration
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepositoryImpl();
    }

    @Bean
    public RewardRepository rewardRepository() {
        return new JdbcRewardRepositoryImpl();
    }

    @Bean
    public TransactionRepository transactionRepository() {
        return new JdbcTransactionRepositoryImpl();
    }

    @Bean
    public EmailService emailService() {
        return new EmailServiceImpl();
    }

    @Bean
    public BankService bankService() {
        BankServiceImpl bs = new BankServiceImpl();
        /*bs.setAccountRepository(accountRepository());
        bs.setEmailService(emailService());
        bs.setRewardRepository(rewardRepository());
        bs.setTransactionRepository(transactionRepository());*/
        return bs;
    }
}
