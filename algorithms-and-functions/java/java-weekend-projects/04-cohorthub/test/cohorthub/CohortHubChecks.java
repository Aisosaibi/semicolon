package cohorthub;

// Verifies collection invariants and FIFO order without interactive console input.
public class CohortHubChecks {
    // Exercises uniqueness, duplicate membership, FIFO support, cleanup, and stable sorting.
    public static void main(String[] args) {
        App.CohortManager manager = new App.CohortManager();
        manager.registerLearner("L2", "Zara", "zara@example.com");
        manager.registerLearner("L1", "Ada", "ada@example.com");
        check(manager.sortedLearners().get(0).getId().equals("L1"),
                "Learner display order should sort by name.");
        expectFailure(() -> manager.registerLearner("L2", "Other", "other@example.com"));
        expectFailure(() -> manager.registerLearner("L3", "Other", "ADA@example.com"));
        manager.createGroup("Java");
        manager.assignToGroup("java", "L1");
        manager.assignToGroup("Java", "L1");
        check(manager.statistics().contains("Java members: 1"), "Duplicate membership was stored.");
        manager.requestSupport("L2");
        manager.requestSupport("L1");
        expectFailure(() -> manager.requestSupport("L2"));
        check(manager.attendNext().getId().equals("L2"), "Support queue is not FIFO.");
        manager.removeLearner("L1");
        check(manager.groupsFor("L2").isEmpty(), "Unexpected group membership.");
        check(manager.sortedLearners().get(0).getId().equals("L2"),
                "Sorted view or learner lookup is incorrect after removal.");
        check(manager.statistics().contains("Java members: 0"),
                "Removing a learner left a stale group membership.");
        check(manager.statistics().contains("waiting for support: 0"),
                "Removing a queued learner left a stale request.");
        expectFailure(manager::attendNext);
        System.out.println("CohortHub checks passed.");
    }

    // Checks a condition and identifies its failed acceptance criterion.
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    // Confirms invalid operations produce the documented user-facing exception.
    private static void expectFailure(Runnable operation) {
        try {
            operation.run();
            throw new AssertionError("Expected an invalid operation to fail.");
        } catch (IllegalArgumentException expected) {
            // The expected exception confirms this negative case.
        }
    }
}
