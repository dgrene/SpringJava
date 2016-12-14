package com.kumard.repository;

import com.kumard.model.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

/*@Component("transactionRepository")*/
public class JdbcTransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public JdbcTransactionRepositoryImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }*/


    public Long addTransaction(TransactionDetail transactionDetail) throws SQLException {
        System.out.println("Adding transaction : " + transactionDetail.getTxType());
        String query = "insert into transactiondetail(accountnumber,transactiondate,amount,txtype) values(?,?,?,?) ";
        jdbcTemplate.update(query, transactionDetail.getAccountNumber(), transactionDetail.getTransactionDate(),
                transactionDetail.getAmount(), transactionDetail.getTxType().toString());


        return null;
    }


    public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException {
        String query = "select * from TransactionDetail td where td.accountNumber=?";

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<TransactionDetail>(TransactionDetail.class));
    }

}
