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
    public void withdrawal(double amount, Date date) throws RuntimeException {
        double res = getBalance();
        double fees = getServiceFee();
        res -= amount + fees;
        if (res < 0) {
            throw new RuntimeException("Error. Transaction canceled.");
        }
        setBalance(res);
        transactionAmount = amount;
        transactionType = "WTH";
        transactionDate = date;
        displayTransaction(fees);
    }
    @Override
    public void deposit(double amount, Date date) throws RuntimeException {
        double res = getBalance() + amount - getServiceFee();
        if (res < 0) {
            throw new RuntimeException("Error. Transaction canceled.");
        }
        setBalance(res);
        transactionAmount = amount;
        transactionType = "DEP";
        transactionDate = date;
        displayTransaction(getServiceFee());
    }
}
