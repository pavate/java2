package atm;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class ATM {

    public static void main(String[] args) {

        int accountChoice;
        int exit = 0;
        int identity;
        int inOption = 0;
        ATM atm = new ATM();
      
                
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Account account1 = new Account("Vinayak", 101);
        Account account2 = new Account("MonsterCat", 102);
        account1.deposit(50);
        account2.deposit(1000);
        account1.setAnnualInterestRate(5);
        account2.setAnnualInterestRate(5);
        int exitAtm;
       do{
            do {
                System.out.println("Enter your account ID");              
                identity = input.nextInt();
                if (((identity == 101) || (identity == 102))) {
                    accountChoice = 1;

                } else {
                    System.out.println("Please enter a valid ID");
                    accountChoice = 0;

                }

            
            } while (accountChoice == 0);
           
            if (identity == 101) {
                atm.menu(account1);
            }
            if (identity == 102) {

               atm.menu(account2);
            }
       }while(inOption==0);

       
    
    }

    public void menu(Account acc) {
        Scanner input3 = new Scanner(System.in);
        int inOption = 0;
        int exitAtm = 0;
        do{
        System.out.println("Main Menu");
        System.out.println("1: Account info");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
        System.out.println("Please choose what you'd like to do:");
        int option = input3.nextInt();

        switch (option) {
            case 1:
                System.out.println("Customer: " + acc.getCustomerName());
                System.out.println("Account Balance: $" + acc.getBalance());
                System.out.println("Monthly interest earned: $" + acc.monthlyInterest());
                System.out.println("\n");
                inOption = 1;
                break;
            case 2:
                System.out.print("Enter the amout to withdraw:");
                int withdrawAmount = input3.nextInt();
                acc.withdraw(withdrawAmount);
                inOption = 1;
                break;
            case 3:
                System.out.print("Enter the amout to deposit:");
                int depositAmount = input3.nextInt();
                acc.deposit(depositAmount);
                inOption = 1;
                break;
            case 4:
                inOption = 0;
                break;
        }
        }while(inOption==1);

    }
}
