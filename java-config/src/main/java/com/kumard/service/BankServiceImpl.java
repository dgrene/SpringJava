package com.kumard.service;

import com.kumard.model.Account;
import com.kumard.model.TransactionDetail;
import com.kumard.model.TransactionType;
import com.kumard.repository.AccountRepository;
import com.kumard.repository.RewardRepository;
import com.kumard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by deepak on 4/12/16.
 */
/*@Component("bankService")*/
public class BankServiceImpl implements BankService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private EmailService emailService;

    public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
        Long transactionId = debit(amount, fromAccountNumber);
        credit(amount, toAccountNumber);
        return transactionId;
    }

    public Long debit(int amount, Long accountNumber) throws SQLException {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        account.debit(amount);
        accountRepository.update(account);
        TransactionDetail fromTransactionDetail =
                new TransactionDetail(accountNumber, new Date(), amount, TransactionType.DEBIT);

        Long transactionId = transactionRepository.addTransaction(fromTransactionDetail);

        if (emailService != null) {
            emailService.sendMail(account.getEmailAddress(),
                    "admin@mybank.com", amount + " has been debited from your account");
        }

        return transactionId;

    }

    public Long credit(int amount, Long accountNumber) throws SQLException {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        account.credit(amount);
        accountRepository.update(account);
        TransactionDetail toTransactionDetail =
                new TransactionDetail(accountNumber, new Date(), amount, TransactionType.CREDIT);

        Long transactionId = transactionRepository.addTransaction(toTransactionDetail);
        if (emailService != null) {
            emailService.sendMail(account.getEmailAddress(), "admin@mybank.com", amount + " has been credited into your account");
        }

        return transactionId;
    }

    public void createNewAccount(Account account) throws SQLException {
        accountRepository.save(account);

    }

    public void deActivateAccount(Long accountNumber) throws SQLException {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        account.setActive(false);
        accountRepository.update(account);

    }

    public void activateAccount(Long accountNumber) throws SQLException {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        account.setActive(true);
        accountRepository.update(account);

    }

    public List<Account> getAllAccounts() throws SQLException {
        System.out.println("BankServiceImpl.getAllAccounts()");
        return accountRepository.findAllAccounts();
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void setRewardRepository(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
