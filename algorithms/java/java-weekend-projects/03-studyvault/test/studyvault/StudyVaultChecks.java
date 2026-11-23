package studyvault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Uses isolated temporary folders to verify StudyVault persistence and buffered copying.
public class StudyVaultChecks {
    // Tests UTF-8, appending, searching, export, restore protection, and invalid paths.
    public static void main(String[] args) throws Exception {
        Path root = Files.createTempDirectory("studyvault-checks");
        try {
            App.NoteStore store = new App.NoteStore(root.resolve("notes"), root.resolve("backups"));
            store.initialize();
            store.createNote("java notes", "First line ₦");
            store.appendNote("java notes", "Second line");
            check(store.readNote("java notes").equals("First line ₦" + System.lineSeparator() + "Second line"),
                    "UTF-8 read or append failed.");
            check(store.search("SECOND").size() == 1, "Case-insensitive line search failed.");
            store.exportNote("java notes");
            check(Files.mismatch(root.resolve("notes/java notes.txt"),
                    root.resolve("backups/java notes.txt")) == -1, "Exported bytes differ.");
            store.deleteNote("java notes");
            store.restoreNote("java notes");
            check(store.readNote("java notes").contains("₦"), "Restore did not preserve UTF-8 content.");
            expectIOException(() -> store.restoreNote("java notes"));
            expectIllegalArgument(() -> store.createNote("../outside", "unsafe"));
            expectIOException(() -> store.readNote("missing"));
            System.out.println("StudyVault checks passed.");
        } finally {
            deleteTree(root);
        }
    }

    // Checks a boolean condition and names the failed behavior.
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    // Confirms a storage operation reports a missing or conflicting file as IOException.
    private static void expectIOException(IoOperation operation) throws Exception {
        try {
            operation.run();
            throw new AssertionError("Expected IOException.");
        } catch (IOException expected) {
            // The expected exception confirms this negative case.
        }
    }

    // Confirms unsafe titles are rejected before reaching the filesystem.
    private static void expectIllegalArgument(IoOperation operation) throws Exception {
        try {
            operation.run();
            throw new AssertionError("Expected IllegalArgumentException.");
        } catch (IllegalArgumentException expected) {
            // The expected exception confirms this validation case.
        }
    }

    // Deletes only the known temporary test tree, in reverse path order.
    private static void deleteTree(Path root) throws IOException {
        try (var paths = Files.walk(root)) {
            for (Path path : paths.sorted(java.util.Comparator.reverseOrder()).toList()) {
                Files.deleteIfExists(path);
            }
        }
    }

    // Represents a test action that can report checked file-operation errors.
    @FunctionalInterface
    private interface IoOperation {
        void run() throws Exception;
    }
}
