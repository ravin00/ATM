import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        balance = initialBalance;
        this.pin = pin;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("PIN successfully changed.");
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0, 1234); // Initial balance and PIN

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == atm.pin) {
            System.out.println("PIN accepted. What would you like to do?");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePin(newPin);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}


