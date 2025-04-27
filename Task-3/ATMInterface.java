import java.util.Scanner;

public class ATMInterface {

    // BankAccount class to represent user account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }
    }

    // ATM logic
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void showMenu() {
            int option;
            do {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> checkBalance();
                    case 2 -> deposit();
                    case 3 -> withdraw();
                    case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } while (option != 4);
        }

        private void checkBalance() {
            System.out.println("Your current balance is: $" + String.format("%.2f", account.getBalance()));
        }

        private void deposit() {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            if (account.deposit(amount)) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        }

        private void withdraw() {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Withdrawal failed. Check if you have sufficient balance or entered a valid amount.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Starting balance
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}