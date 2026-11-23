package safebank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Runs the SafeBank console application and keeps input/output out of Account's business rules.
public class App {
    // Starts the menu loop and reports expected input or business-rule errors without a stack trace.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account;
        // Keep asking until the user supplies a valid account name and opening balance.
        while (true) {
            try {
                System.out.print("Account holder: ");
                String name = input.nextLine().trim();
                System.out.print("Opening balance (₦): ");
                double openingBalance = Double.parseDouble(input.nextLine().trim());
                account = new Account(name, openingBalance);
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a numeric opening balance.");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        // Continue until the user explicitly selects the exit option.
        boolean running = true;
        while (running) {
            System.out.println("\nSafeBank — 1 Deposit | 2 Withdraw | 3 Balance/history | 0 Exit");
            System.out.print("Choice: ");
            String choice = input.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Deposit amount (₦): ");
                        account.deposit(parseAmount(input.nextLine()));
                        System.out.println("Deposit completed.");
                    }
                    case "2" -> {
                        System.out.print("Withdrawal amount (₦): ");
                        account.withdraw(parseAmount(input.nextLine()));
                        System.out.println("Withdrawal completed.");
                    }
                    case "3" -> {
                        System.out.printf("Balance: ₦%.2f%n", account.getBalance());
                        System.out.println("Successful transactions:");
                        account.getHistory().forEach(System.out::println);
                    }
                    case "0" -> running = false;
                    default -> System.out.println("Choose 1, 2, 3, or 0.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a numeric amount.");
            } catch (InvalidAmountException | InsufficientFundsException
                     | WithdrawalLimitExceededException exception) {
                System.out.println("Transaction rejected: " + exception.getMessage());
            }
        }
        System.out.println("Goodbye.");
    }

    // Converts a menu input line to an amount, leaving user-friendly handling to the menu.
    private static double parseAmount(String text) {
        return Double.parseDouble(text.trim());
    }

    // Owns the balance and only records transactions after all validations pass.
    static final class Account {
        private static final double WITHDRAWAL_LIMIT = 100_000.00;
        private final String holderName;
        private final List<String> history = new ArrayList<>();
        private double balance;

        // Creates an account only when its required opening values are valid.
        Account(String holderName, double openingBalance) {
            if (holderName == null || holderName.isBlank()) {
                throw new IllegalArgumentException("Account holder name must not be blank.");
            }
            if (!Double.isFinite(openingBalance) || openingBalance < 0) {
                throw new IllegalArgumentException("Opening balance must be a non-negative number.");
            }
            this.holderName = holderName;
            this.balance = openingBalance;
        }

        // Deposits a positive finite amount and records the successful operation.
        void deposit(double amount) throws InvalidAmountException {
            validateAmount(amount);
            double updatedBalance = balance + amount;
            if (!Double.isFinite(updatedBalance)) {
                throw new InvalidAmountException("Amount would make the balance too large.");
            }
            balance = updatedBalance;
            history.add(String.format("Deposit: +₦%.2f", amount));
        }

        // Checks every withdrawal rule before changing the balance or transaction history.
        void withdraw(double amount) throws InvalidAmountException,
                InsufficientFundsException, WithdrawalLimitExceededException {
            validateAmount(amount);
            if (amount > WITHDRAWAL_LIMIT) {
                throw new WithdrawalLimitExceededException("A single withdrawal cannot exceed ₦100,000.");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("The account does not have enough funds.");
            }
            balance -= amount;
            history.add(String.format("Withdrawal: -₦%.2f", amount));
        }

        // Rejects zero, negative, NaN, and infinite values as invalid monetary amounts.
        private static void validateAmount(double amount) throws InvalidAmountException {
            if (!Double.isFinite(amount) || amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than zero.");
            }
        }

        // Returns the current balance for display and acceptance checks.
        double getBalance() {
            return balance;
        }

        // Returns a read-only snapshot so callers cannot alter successful history.
        List<String> getHistory() {
            return List.copyOf(history);
        }

        // Returns the account holder's name.
        String getHolderName() {
            return holderName;
        }
    }

    // Represents an invalid deposit or withdrawal amount.
    static class InvalidAmountException extends Exception {
        InvalidAmountException(String message) {
            super(message);
        }
    }

    // Represents a withdrawal larger than the available balance.
    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String message) {
            super(message);
        }
    }

    // Represents a withdrawal above the configured per-transaction limit.
    static class WithdrawalLimitExceededException extends Exception {
        WithdrawalLimitExceededException(String message) {
            super(message);
        }
    }
}
