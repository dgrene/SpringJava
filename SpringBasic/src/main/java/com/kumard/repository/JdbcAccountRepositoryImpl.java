package com.kumard.repository;

import com.kumard.model.Account;
import com.kumard.model.Address;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak on 4/12/16.
 */
public class JdbcAccountRepositoryImpl implements AccountRepository {
    private DataSource dataSource;

    public JdbcAccountRepositoryImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public Account findAccountByNumber(Long accountNumber) throws SQLException {
        String query = "SELECT * FROM account WHERE accountNumber = ?";
        Connection connnection = dataSource.getConnection();
        PreparedStatement preparedStatement = connnection.prepareStatement(query);
        preparedStatement.setLong(1, accountNumber);
        ResultSet rs = preparedStatement.executeQuery();
        Account account = null;
        if (rs.next()) {
            account = new Account();
            account.setName(rs.getString("name"));
            account.setAccountNumber(rs.getLong("accountNumber"));
            account.setActive(rs.getBoolean("isactive"));
            Address address = new Address();
            address.setCity(rs.getString("city"));
            address.setCountry(rs.getString("country"));
            account.setAddress(address);
            account.setBalance(rs.getInt("balance"));
            account.setEmailAddress(rs.getString("emailaddress"));
        }
        connnection.close();
        return account;
    }

    @Override
    public List<Account> findAllAccounts() throws SQLException {
        String query = "Select * from account";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        List<Account> accounts = null;
        while (rs.next()) {
            if (accounts == null) {
                accounts = new ArrayList<Account>();
            }
            Account account = new Account();
            account.setName(rs.getString("name"));
            account.setAccountNumber(rs.getLong("accountNumber"));
            account.setActive(rs.getBoolean("isactive"));
            Address address = new Address();
            address.setCity(rs.getString("city"));
            address.setCountry(rs.getString("country"));
            account.setAddress(address);
            account.setBalance(rs.getInt("balance"));
            account.setEmailAddress(rs.getString("emailaddress"));
            accounts.add(account);
        }
        connection.close();
        return accounts;
    }

    @Override
    public void save(Account account) throws SQLException {
        String query = "update account set name=?,isactive=?,city=?,country=?,balance=?,emailaddress=? where accountnumber=?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, account.getName());
        preparedStatement.setBoolean(2, account.isActive());
        preparedStatement.setString(3, account.getAddress().getCity());
        preparedStatement.setString(4, account.getAddress().getCountry());
        preparedStatement.setInt(5, account.getBalance());
        preparedStatement.setString(6, account.getEmailAddress());
        preparedStatement.setLong(7, account.getAccountNumber());
        preparedStatement.executeUpdate();
        System.out.println("Account updated");
    }

    @Override
    public void update(Account account) throws SQLException {
        String query = "update account set name=?,isactive=?,city=?,country=?,balance=?,emailaddress=? where accountnumber=?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, account.getName());
        preparedStatement.setBoolean(2, account.isActive());
        preparedStatement.setString(3, account.getAddress().getCity());
        preparedStatement.setString(4, account.getAddress().getCountry());
        preparedStatement.setInt(5, account.getBalance());
        preparedStatement.setString(6, account.getEmailAddress());
        preparedStatement.setLong(7, account.getAccountNumber());
        preparedStatement.executeUpdate();
        System.out.println("Account updated");
    }

    @Override
    public void delete(Account account) throws SQLException {
        String query = "delete from  account a where  a.accountnumber=?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, account.getAccountNumber());
        preparedStatement.executeUpdate();
        System.out.println("Account Deleted");

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
