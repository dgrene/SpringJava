package com.kumard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by deepak on 4/12/16.
 */
public class BankServiceImpl implements BankService {

    @Autowired
    private AccountService accountService;


    @Transactional
    public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
        Long transactionId = accountService.debit(amount, fromAccountNumber);
        accountService.credit(amount, toAccountNumber);

        return transactionId;

    }


}
