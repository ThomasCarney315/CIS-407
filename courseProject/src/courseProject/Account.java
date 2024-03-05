package courseProject;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account {
    private String accountHolder;
    private String accountNumber;
    private String accountType;
    private double serviceFee;
    private double interestRate;
    private double overdraftFee;
    private double balance = 0;
    //constructor for initializing with values
    public Account (String accountNumber, String accountType, double serviceFee,
             double interestRate, double overdraftFee, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.serviceFee = serviceFee;
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
        this.balance = balance;
    }
    //constructor for initializing blank Account instance
    public Account () {

    }
    //setters
    public void setAccountHolder(String id) { this.accountHolder = id; }
    public void setAccountNumber (String number) { this.accountNumber = number; }
    public void setAccountType (String type) { this.accountType = type; }
    public void setServiceFee (double n) { this.serviceFee = n; }
    public void setInterestRate (double n) { this.interestRate = n; }
    public void setOverdraftFee (double n) { this.overdraftFee = n; }
    public void setBalance (double n) { this.balance = n; }
    //getters

    public String getAccountHolder() { return this.accountHolder; }
    public String getAccountNumber () { return this.accountNumber; }
    public String getAccountType () { return this.accountType; }
    public double getServiceFee () { return this.serviceFee; }
    public double getInterestRate () { return this.interestRate; }
    public double getOverdraftFee () { return this.overdraftFee; }
    public double getBalance () { return this.balance; }
    public abstract void withdrawal(double amount, Date date);
    public abstract void deposit(double amount, Date date);
    public abstract Date getTransactionDate();
    public abstract String getTransactionType();
    public abstract double getTransactionAmount();
    //toString method
    public String toString() {
        String res = String.format("Account Details:\n\n"
                + "Account Holder:  %s\n"
                + "Account Number:  %s\n"
                + "  Account Type:  %s\n"
                + "   Service Fee:  %s\n"
                + " Interest Rate:  %s\n"
                + " Overdraft Fee:  %s\n"
                + "       Balance:  %s\n",accountHolder, accountNumber, accountType, serviceFee, interestRate, overdraftFee, balance);
        return res;
    }
    protected void displayTransaction(double fees) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String res = String.format("Transaction Details:\n\n"
                + "     Customer ID:  %s\n"
                + "  Account Number:  %s\n"
                + "    Account Type:  %s\n"
                + "Transaction Date:  %s\n"
                + "Transaction Type:  %s\n"
                + " Transaction Amt:  %s\n"
                + "            Fees:  %s\n"
                + "         Balance:  %s\n", getAccountHolder(), getAccountNumber(), getAccountType(), sdf.format(getTransactionDate()), getTransactionType(), getTransactionAmount(), fees, getBalance());
        JOptionPane.showMessageDialog(null,res, "Success", JOptionPane.PLAIN_MESSAGE);
    }
    public void addInterest() {
        setBalance(balance + (balance * interestRate));
    }
}
