package com.kumard.model;

import java.util.Set;

/**
 * Created by deepak on 4/12/16.
 */
public class Account {
    private Long accountNumber;
    private String name;
    private boolean isActive;

    private Set<Benificiary> benificiaries;

    private Address address;

    private int balance;
    private String emailAddress;

    public Account() {

    }

    public Account(Long accountNumber, String name, boolean isActive,
                   int balance, String emailAddress, String city, String country) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.isActive = isActive;
        this.emailAddress = emailAddress;

        Address address = new Address();
        address.setCity(city);
        address.setCountry(country);
        this.address = address;
    }

    public void debit(int amount) {
        balance = balance - amount;
    }

    public void credit(int amount) {
        balance = balance + amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Benificiary> getBenificiaries() {
        return benificiaries;
    }

    public void setBenificiaries(Set<Benificiary> benificiaries) {
        this.benificiaries = benificiaries;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
