package com.kumard.service;

import java.sql.SQLException;

/**
 * Created by deepak on 4/12/16.
 */
public interface BankService {
    Long transfer(Long fromAccount, Long toAccount, int amount) throws SQLException;


}
