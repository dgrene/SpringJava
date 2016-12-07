package com.kumard.repository;

import com.kumard.model.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by deepak on 4/12/16.
 */
public interface AccountRepository {
    Account findAccountByNumber(Long accountNumber) throws SQLException;

    List<Account> findAllAccounts() throws SQLException;

    void save(Account account) throws SQLException;

    void update(Account account) throws SQLException;

    void delete(Account account) throws SQLException;
}
