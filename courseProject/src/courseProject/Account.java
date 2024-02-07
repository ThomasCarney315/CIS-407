package courseProject;

public class Account {
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
    public void setAccountNumber (String number) { this.accountNumber = number; }
    public void setAccountType (String type) { this.accountType = type; }
    public void setServiceFee (double n) { this.serviceFee = n; }
    public void setInterestRate (double n) { this.interestRate = n; }
    public void setOverdraftFee (double n) { this.overdraftFee = n; }
    public void setBalance (double n) { this.balance = n; }
    //getters
    public String getAccountNumber () { return this.accountNumber; }
    public String getAccountType () { return this.accountType; }
    public double getServiceFee () { return this.serviceFee; }
    public double getInterestRate () { return this.interestRate; }
    public double getOverdraftFee () { return this.overdraftFee; }
    public double getBalance () { return this.balance; }
    //toString method
    public String toString() {
        String res = String.format("Account Details:\n\n"
                + "Account Number:  %s\n"
                + "  Account Type:  %s\n"
                + "   Service Fee:  %s\n"
                + " Interest Rate:  %s\n"
                + " Overdraft Fee:  %s\n"
                + "       Balance:  %s\n",accountNumber, accountType, serviceFee, interestRate, overdraftFee, balance);
        return res;
    }
}
