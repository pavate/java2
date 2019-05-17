package atm;

import java.util.Scanner;

/**
 *
 * @author Vinayak Pavate
 */
public class ATM {

    public static void main(String[] args) {

        //idChoice is used as a loop initiator when the customer enters their ID
        boolean idChoice;

        //We will be using this variable to be testing if the ID is correct
        int id;

        //boolean exitMenu is used in the loop when we exit the menu
        boolean exitMenu;

        //Creating a new istance of the class ATM
        ATM atm = new ATM();
        Scanner input = new Scanner(System.in);

        //We create first account
        Account account1 = new Account("Vinayak", 101);


        /*The method deposit is used as the customer deposits the
        amount when they make a new account */
        account1.deposit(50.0);
        account1.setAnnualInterestRate(5);

        //We create the second account 
        Account account2 = new Account("Johnny Depp", 102);
        account2.deposit(1000.0);
        account2.setAnnualInterestRate(5);

        //Start of the ATM loop
        do {
            //Start of ID input loop
            do {

                System.out.println("Hi, Welcome to the ATM");
                System.out.println("Enter your account ID");
                id = input.nextInt();
                //Only two account Id are allowed
                if (((id == 101) || (id == 102))) {
                    idChoice = true;

                } else {
                    System.out.println("I'm sorry something seems wrong");
                    System.out.println("Please enter a valid ID");
                    idChoice = false;

                }

            } while (idChoice = false);

            if (id == 101) {
                atm.menu(account1);//calling the menu method for 101
                exitMenu = true;
            }
            if (id == 102) {
                atm.menu(account2);//calling the menu method for 102
                exitMenu = true;
            }
        } while (exitMenu = true);
    }

    //Menu method
    /**
     *
     * @param acc This is a class parameter which uses the Object account to be
     * used in the menu method
     */
    public void menu(Account acc) {
        Scanner scan = new Scanner(System.in);
        int inOption = 0;//Used as a loop element for menu
        int caseError; //Used as a loop element for try and catch
        //Start Menu loop
        do {
            System.out.println("Main Menu");
            System.out.println("1: Account info");
            System.out.println("2: Withdraw");
            System.out.println("3: Deposit");
            System.out.println("4: Exit");
            System.out.println("Please choose what you'd like to do:");
            int menuOption = scan.nextInt();

            //We are using switch to explore our menu options
            switch (menuOption) {
                case 1://Shows the Account Info
                    System.out.println("Customer: " + acc.getCustomerName());
                    System.out.printf("Account Balance: $%.2f\n", acc.getBalance());
                    System.out.printf("Monthly interest earned: $%.2f", acc.monthlyInterest());
                    System.out.println("\n");
                    inOption = 1;
                    break;
                case 2://To Withdraw amount from accounts

                    System.out.print("Enter the amout to withdraw:");
                    double withdrawAmount = scan.nextDouble();
                    try {
                        acc.withdraw(withdrawAmount);

                    } catch (Throwable e) {
                        System.out.println(e.getMessage());
                        System.out.println("\n");

                    }

                    inOption = 1;
                    break;
                case 3://To Deposit amout to accounts

                    System.out.print("Enter the amout to deposit:");
                    double depositAmount = scan.nextDouble();
                    try {
                        acc.deposit(depositAmount);

                    } catch (Throwable e) {
                        System.out.println(e.getMessage());
                        System.out.println("\n");
                        caseError = 0;
                    }

                    inOption = 1;
                    break;
                case 4://To exit the menu
                    inOption = 0;
                    break;
            }
        } while (inOption == 1);

    }

}
