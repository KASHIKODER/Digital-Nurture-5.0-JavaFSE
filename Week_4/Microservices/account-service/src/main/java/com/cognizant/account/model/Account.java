package com.cognizant.account.model;

public class Account {
    private Long accountId;
    private String accountType;
    private Double balance;
    private String customerName;

    public Account() {}

    public Account(Long accountId, String accountType, Double balance, String customerName) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.customerName = customerName;
    }

    public Long getAccountId() { return accountId; }
    public String getAccountType() { return accountType; }
    public Double getBalance() { return balance; }
    public String getCustomerName() { return customerName; }
}