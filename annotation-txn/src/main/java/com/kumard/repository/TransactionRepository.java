package com.kumard.repository;

import com.kumard.model.TransactionDetail;

import java.sql.SQLException;
import java.util.List;


public interface TransactionRepository {

    Long addTransaction(TransactionDetail transactionDetail) throws SQLException;

    List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException;
}
