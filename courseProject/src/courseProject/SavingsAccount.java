package courseProject;

import java.util.Date;

public class SavingsAccount extends Account {
    private Date transactionDate;
    private String transactionType;
    private double transactionAmount;
    public SavingsAccount() {
        super(null, "SAV", 0.25, 0.05, 0, 0);
    }
    //getters
    @Override
    public Date getTransactionDate() { return transactionDate;}
    @Override
    public String getTransactionType() { return transactionType;}
    @Override
    public double getTransactionAmount() { return transactionAmount;}
    @Override
    public void withdrawal(double amount, Date date) {
        double res = getBalance();
        double fees = getServiceFee();
        try {
            res -= amount + fees;
            if (res < 0) {
                throw new RuntimeException();
            }
            setBalance(res);
            transactionAmount = amount;
            transactionType = "WTH";
            transactionDate = date;
        }
        catch (Exception e) {
            System.out.println("Error. Transaction canceled.");
        }
        displayTransaction(fees);
    }
    @Override
    public void deposit(double amount, Date date) {
        double res = getBalance() + amount - getServiceFee();
        try {
            if (res < 0) {
                throw new RuntimeException();
            }
            setBalance(res);
            transactionAmount = amount;
            transactionType = "DEP";
            transactionDate = date;
        }
        catch (Exception e) {
            System.out.println("Error. Transaction canceled.");
        }
        displayTransaction(getServiceFee());
    }
}
