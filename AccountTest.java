import java.io.FileWriter;
import java.io.IOException;

abstract class Banking_Problem {
    // creating the abstract class
    // declaring account name and balance as state
    protected String accountName;
    protected double balance;

    // constructor to set the states when creating an object
    public Banking_Problem(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public abstract double getBalance();

    protected void logTransaction(String message) {
        try (FileWriter writer = new FileWriter("Bank.txt", true)) {
            writer.write(accountName + ": " + message + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
Account.java
class Account extends Banking_Problem {
    public Account(String accountName, double balance) {
        super(accountName, balance);
    }

    @Override
    // abstract methods deposit, withdraw and getBalance as behavior.
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrew: $" + amount);
            logTransaction("Withdrew $" + amount + " | Balance: $" + balance);
        } else {
            System.out.println("Withdrawal amount exceeded account balance");
            logTransaction("Failed withdrawal of $" + amount);

        }

    }

    @Override
    // In Java, an abstract class should only declare methods, not implement them.
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: $" + amount);
            logTransaction("Deposited $" + amount);
        } else {
            System.out.println("Invalid Deposit Amount");
            logTransaction("Failed deposit of $" + amount);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}


AccountTest.java
public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account("Rodney", 150000);

        acc.deposit(1500);
        acc.withdraw(2000);
        acc.withdraw(4500);

        System.out.println("Final Balance: $" + acc.getBalance());
    }
}
