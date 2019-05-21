package atm;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the main part of the ATM where the main input and output happens.
 * Date: 05/21/2019
 *
 * @author Vinayak Pavate
 */
public class ATM {

    public static void main(String[] args) {

        //idChoice is used as a loop initiator when the customer enters their ID
        boolean idChoice;

        //We will be using this variable to be testing if the ID is correct
        int id = 0;

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
                if (input.hasNextInt()) {
                    id = input.nextInt();

                    if (((id == 101) || (id == 102))) {
                        idChoice = true;
                    } else {
                        System.out.println("Please enter a valid ID");
                    }
                } else {
                    System.out.println("I'm sorry something seems wrong");
                    System.out.println("Please enter a valid ID\n");
                    idChoice = false;
                }
                input.nextLine();

            } while (idChoice = false);

            if (id == 101) {
                atm.menu(account1);//calling the menu method for 101
                //exitMenu = true;
            }
            if (id == 102) {
                atm.menu(account2);//calling the menu method for 102
                // exitMenu = true;
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
        int inOption = 1;//Used as a loop element for menu

        //Start Menu loop        
        do {
            System.out.println("Main Menu");
            System.out.println("1: Account info");
            System.out.println("2: Withdraw");
            System.out.println("3: Deposit");
            System.out.println("4: Exit");
            System.out.println("Please choose what you'd like to do:");
            if (scan.hasNextInt()) {
                int menuOption = scan.nextInt();
                try {
                    //We are using switch to explore our menu options
                    switch (menuOption) {
                        case 1: //Shows the Account Info
                            System.out.println(acc.toString());
                            inOption = 1;
                            break;

                        case 2: //To Withdraw amount from accounts
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
                        case 3: //To Deposit amout to accounts

                            System.out.print("Enter the amout to deposit:");
                            double depositAmount = scan.nextDouble();
                            try {
                                acc.deposit(depositAmount);

                            } catch (Throwable e) {
                                System.out.println(e.getMessage());
                                System.out.println("\n");
                            }

                            inOption = 1;
                            break;
                        case 4: //To exit the menu
                            inOption = 0;
                            break;
                        default:
                            System.out.println("Please enter a valid Menu option");
                            inOption = 1;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("hahaha");
                }
            } else {
                System.out.println("Please enter a valid Menu option");
            }
            scan.nextLine();

        } while (inOption == 1);

    }

}
