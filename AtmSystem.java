import java.util.Scanner;
class Account {
    int balance;
    Account(int balance) {
        this.balance = balance;
    }
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
class ATM {
    int amt;
    void deposit(Account acc, int amt) {
        acc.balance = acc.balance + amt;
        System.out.println("Deposited Successfully");
        System.out.println("Updated Account Balance is: " + acc.balance);
    }
    void withdraw(Account acc, int amt) {
        if (amt > acc.balance) {
            System.out.println("Insufficient balance, try again");
        } else {
            acc.balance = acc.balance - amt;
            System.out.println("Withdraw Successful");
            System.out.println("Remaining Balance: " + acc.balance);
        }
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc = new Account(10000);
        ATM atm = new ATM();

        int choice, repeat = 1;

        System.out.println("Welcome to ATM");

        while (repeat == 1) {
            System.out.println("\n1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.print("Enter option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    acc.displayBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    atm.deposit(acc, dep);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int wd = sc.nextInt();
                    atm.withdraw(acc, wd);
                    break;

                default:
                    System.out.println("Invalid option");
            }

            System.out.println("\nDo you want to repeat?");
            System.out.println("1. Repeat  2. Exit");
            repeat = sc.nextInt();
        }

        System.out.println("ATM session ended.");
    }
}
