package atm;

/**
 * This is the running part of The Account class
 *
 * @author Vinayak
 */
public class Account {

    //Defining the 4 field sets required to set a basic account up
    private String customerName;
    private final int id;
    private double balance;
    private double annualInterestRate;

    //Default constructor with customer name and their ID number
    /**
     *
     * @param customerName This is a constructor parameter for customer name
     * @param id This is a constructor parameter for the id of the customer
     */
    public Account(String customerName, int id) {
        this.customerName = customerName;
        this.id = id;
    }
//setter to set the name of the customer

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
//setter to set the interest rate of the specific account

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
//getter to get the customer name

    public String getCustomerName() {
        return customerName;
    }
//getter to retrive the ID of the customer

    public int getId() {
        return id;
    }
//getter to retrive the balance of the customer

    public double getBalance() {
        return balance;
    }
//getter to retrive the annual interest rate of a specific account

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * //Withdraw method to deduct money from account
     *
     * @param amount User input to withdraw specified amount from balance
     */
    public void withdraw(double amount) {

        /* If the customer tries to withdraw an amount
        which is greater than their account balance */
        if (((balance - amount) < 0) || (balance == 0)) {
            throw new IllegalArgumentException("Insufficient Funds to process request");

            /*customer cant withdraw a "0" amount will throw an exception to
        draw a diffrent amount */
        }
        if ((amount < 0) || (amount == 0)) {
            throw new IllegalArgumentException("Please enter a vaild amount to withdraw");

        }
        if (amount > 0) {
            balance = balance - amount;
        }
    }

    /**
     * Deposit method is to add money to the balance of the account
     *
     * @param amount User input to deposit amount to their account
     */
    public void deposit(double amount) {
        /* Only a amount greater than "0" can be 
        deposited or else throws exception*/

        if (amount > 0) {
            balance = amount + balance;
        } else {
            throw new IllegalArgumentException("Please enter a vaild amount to withdraw");
        }
    }

    /**
     * Method to calculate the monthly interest of the given annual interest
     * rate
     *
     * @return returns the monthly interest rate for a specified account while
     * passing a account object through it
     */
    public double monthlyInterest() {
        double amount = balance * (annualInterestRate / 12 / 100);
        return amount;
    }

    /**
     *
     * @return This returns the String value of the name of the customer account
     * balance and monthly interest of the user
     */
    @Override
    public String toString() {
        String format = "Name of the customer.: %s " +"\n"
                + "Account Balance:%.2f" + "\n"
                + "Monthly interest earned: %s" ;
        return String.format(format, customerName, balance, monthlyInterest());
    }

}
