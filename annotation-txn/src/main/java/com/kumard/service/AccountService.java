package com.kumard.service;

import com.kumard.model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by deepak on 14/12/16.
 */
public interface AccountService {
    Long debit(int amount, Long accountNumber) throws SQLException;

    Long credit(int amount, Long accountNumber) throws SQLException;

    void createNewAccount(Account account) throws SQLException;

    void deActivateAccount(Long accountNumber) throws SQLException;

    void activateAccount(Long accountNumber) throws SQLException;

    List<Account> getAllAccounts() throws SQLException;
}
