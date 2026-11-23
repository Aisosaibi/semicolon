package safebank;

// Runs dependency-free checks for SafeBank's essential business rules.
public class SafeBankChecks {
    // Fails immediately with a useful message if a required behavior changes.
    public static void main(String[] args) throws Exception {
        App.Account account = new App.Account("Ada", 200_000);
        int historyBeforeFailure = account.getHistory().size();
        try {
            account.deposit(-500);
            throw new AssertionError("A negative deposit should fail.");
        } catch (App.InvalidAmountException expected) {
            check(account.getBalance() == 200_000, "Rejected deposit changed balance.");
            check(account.getHistory().size() == historyBeforeFailure, "Rejected deposit changed history.");
        }
        App.Account lowBalanceAccount = new App.Account("Bola", 50_000);
        try {
            lowBalanceAccount.withdraw(60_000);
            throw new AssertionError("An over-balance withdrawal should fail.");
        } catch (App.InsufficientFundsException expected) {
            check(lowBalanceAccount.getBalance() == 50_000, "Rejected withdrawal changed balance.");
        }
        try {
            account.withdraw(120_000);
            throw new AssertionError("A withdrawal over the limit should fail.");
        } catch (App.WithdrawalLimitExceededException expected) {
            check(account.getBalance() == 200_000, "Limit rejection changed balance.");
        }
        account.deposit(500);
        check(account.getBalance() == 200_500, "A successful deposit after failure should work.");
        account.withdraw(1_000);
        check(account.getBalance() == 199_500, "A valid withdrawal should work.");
        System.out.println("SafeBank checks passed.");
    }

    // Uses Java assertions with messages so a failure identifies the broken rule.
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
