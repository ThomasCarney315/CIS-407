package courseProject;

import java.util.Date;

public class CheckingAccount extends Account{
    private Date transactionDate;
    private String transactionType;
    private double transactionAmount;
    public CheckingAccount() {
        super(null, "CHK", 0.5, 0.02, 30, 0);
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
            if (res < 0 && getBalance() >= 0) {
                fees += getOverdraftFee();
                res -= getOverdraftFee();
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
