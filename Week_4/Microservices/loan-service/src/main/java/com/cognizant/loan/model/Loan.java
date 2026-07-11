package com.cognizant.loan.model;

public class Loan {
    private Long loanId;
    private String loanType;
    private Double loanAmount;
    private Double interestRate;
    private String customerName;
    private String status;

    public Loan() {}

    public Loan(Long loanId, String loanType, Double loanAmount, Double interestRate, String customerName, String status) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.customerName = customerName;
        this.status = status;
    }

    public Long getLoanId() { return loanId; }
    public String getLoanType() { return loanType; }
    public Double getLoanAmount() { return loanAmount; }
    public Double getInterestRate() { return interestRate; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
}