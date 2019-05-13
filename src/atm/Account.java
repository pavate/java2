package atm;

/**
 *
 * @author acer
 */
public class Account {

    private String customerName;
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(String customerName, int id) {
        this.customerName = customerName;
        this.id = id;
    }
    

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public void withdraw(double amount){
        if(amount>=0){
            balance = balance-amount;
        }
        else{
            System.out.println("Please add a valid number");
        }        
    }
    public void deposit(double amount){
        if(amount>=0){
            balance = amount+balance;
        }
        else{
            System.out.println("Please add a valid number");
        }        
    }
    public double monthlyInterest(){
        double amount= balance*(annualInterestRate/12/100);
        return amount;
    }

}
