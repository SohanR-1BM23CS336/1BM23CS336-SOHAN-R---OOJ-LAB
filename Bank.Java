import java.util.Scanner;

abstract class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public abstract void withdraw(double amount);

    public abstract void checkMinimumBalance();
}

class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% interest rate

    public SavingsAccount(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    public void computeAndDepositInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest computed and added: " + interest);
        displayBalance();
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
        displayBalance();
    }

    @Override
    public void checkMinimumBalance() {
    }
}

class CurrentAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurrentAccount(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
        displayBalance();
    }

    @Override
    public void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum. Service charge imposed: " + SERVICE_CHARGE);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String customerName = sc.nextLine();
       
        System.out.println("Enter account number:");
        String accountNumber = sc.nextLine();
       
        System.out.println("Enter account type (Savings/Current):");
        String accountType = sc.nextLine();
       
        System.out.println("Enter initial balance:");
        double initialBalance = sc.nextDouble();
       
        Account account;
        if (accountType.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(customerName, accountNumber, initialBalance);
        } else if (accountType.equalsIgnoreCase("Current")) {
            account = new CurrentAccount(customerName, accountNumber, initialBalance);
        } else {
            System.out.println("Invalid account type.");
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Display Balance");
            if (account instanceof SavingsAccount) {
                System.out.println("3. Compute and Deposit Interest");
            }
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    account.displayBalance();
                    break;
                case 3:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).computeAndDepositInterest();
                    } else {
                        System.out.println("Interest calculation not available for current accounts.");
                    }
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}