package com.kumard.repository;

import com.kumard.model.TransactionDetail;
import com.kumard.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*@Component("transactionRepository")*/
public class JdbcTransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private DataSource dataSource;

    /*public JdbcTransactionRepositoryImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }*/


    public Long addTransaction(TransactionDetail transactionDetail) throws SQLException {
        String query = "insert into transactiondetail(accountnumber,transactiondate,amount,txtype) values(?,?,?,?) ";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setLong(1, transactionDetail.getAccountNumber());
        preparedStatement.setDate(2, new Date(transactionDetail.getTransactionDate().getTime()));
        preparedStatement.setInt(3, transactionDetail.getAmount());
        preparedStatement.setString(4, transactionDetail.getTxType().toString());
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            return rs.getLong(1);
        }
        return null;
    }


    public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException {
        String query = "select * from transactiondetail td where td.accountNumber=?";
        Connection connection = dataSource.getConnection();
        ResultSet rs = connection.prepareStatement(query).executeQuery();

        List<TransactionDetail> transactionDetails = new ArrayList<TransactionDetail>();
        while (rs.next()) {
            TransactionDetail transactionDetail = new TransactionDetail();

            transactionDetail.setTransactionId(rs.getLong("transactionId"));
            transactionDetail.setTransactionDate(new Date(rs.getDate("transactionDate").getTime()));
            transactionDetail.setAccountNumber(rs.getLong("accountNumber"));
            transactionDetail.setAmount(rs.getInt("amount"));
            String transactionType = rs.getString("type");
            if (transactionType.equals(TransactionType.CREDIT)) {
                transactionDetail.setTxType(TransactionType.CREDIT);
            } else {
                transactionDetail.setTxType(TransactionType.DEBIT);
            }
            transactionDetails.add(transactionDetail);
        }
        return transactionDetails;
    }

}
