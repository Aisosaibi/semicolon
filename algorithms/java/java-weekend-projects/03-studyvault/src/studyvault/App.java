package studyvault;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

// Presents a menu while delegating all persistence and path checks to NoteStore.
public class App {
    // Creates the storage folders, then handles each selected action until exit.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NoteStore store = new NoteStore(Path.of("notes"), Path.of("backups"));
        try {
            store.initialize();
        } catch (IOException exception) {
            System.out.println("Could not initialize note storage: " + exception.getMessage());
            return;
        }
        boolean running = true;
        while (running) {
            System.out.println("\nStudyVault — 1 Create | 2 List | 3 Open | 4 Append");
            System.out.println("5 Search | 6 Delete | 7 Export | 8 Restore | 9 Details | 0 Exit");
            System.out.print("Choice: ");
            try {
                switch (input.nextLine().trim()) {
                    case "1" -> createNote(input, store);
                    case "2" -> store.listNotes().forEach(System.out::println);
                    case "3" -> System.out.println(store.readNote(readTitle(input)));
                    case "4" -> store.appendNote(readTitle(input), readMultiline(input));
                    case "5" -> search(input, store);
                    case "6" -> delete(input, store);
                    case "7" -> store.exportNote(readTitle(input));
                    case "8" -> store.restoreNote(readTitle(input));
                    case "9" -> System.out.println(store.details(readTitle(input)));
                    case "0" -> running = false;
                    default -> System.out.println("Choose a listed menu number.");
                }
            } catch (IOException | IllegalArgumentException exception) {
                System.out.println("Operation failed: " + exception.getMessage());
            }
        }
        System.out.println("Goodbye.");
    }

    // Creates a note after asking before any replacement of an existing file.
    private static void createNote(Scanner input, NoteStore store) throws IOException {
        String title = readTitle(input);
        if (store.noteExists(title)) {
            System.out.print("That note exists. Overwrite it? (yes/no): ");
            if (!input.nextLine().trim().equalsIgnoreCase("yes")) {
                System.out.println("Creation cancelled.");
                return;
            }
        }
        store.createNote(title, readMultiline(input));
        System.out.println("Note saved.");
    }

    // Searches all notes and prints every matching line with a one-based line number.
    private static void search(Scanner input, NoteStore store) throws IOException {
        System.out.print("Keyword: ");
        store.search(input.nextLine()).forEach(System.out::println);
    }

    // Requires explicit confirmation before deleting a note.
    private static void delete(Scanner input, NoteStore store) throws IOException {
        String title = readTitle(input);
        System.out.print("Delete \"" + title + "\"? (yes/no): ");
        if (input.nextLine().trim().equalsIgnoreCase("yes")) {
            store.deleteNote(title);
            System.out.println("Note deleted.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // Reads a title and leaves validation to the storage boundary.
    private static String readTitle(Scanner input) {
        System.out.print("Note title: ");
        return input.nextLine();
    }

    // Reads lines until a single period is entered, preserving embedded newlines.
    private static String readMultiline(Scanner input) {
        System.out.println("Enter content; type a single . on a line to finish:");
        StringBuilder content = new StringBuilder();
        while (true) {
            String line = input.nextLine();
            if (line.equals(".")) {
                return content.toString();
            }
            if (!content.isEmpty()) {
                content.append(System.lineSeparator());
            }
            content.append(line);
        }
    }

    // Performs UTF-8 note operations and buffered byte copying independently of the menu.
    static final class NoteStore {
        private final Path notesDirectory;
        private final Path backupsDirectory;

        // Accepts separate note and backup locations so tests can use temporary directories.
        NoteStore(Path notesDirectory, Path backupsDirectory) {
            this.notesDirectory = notesDirectory.toAbsolutePath().normalize();
            this.backupsDirectory = backupsDirectory.toAbsolutePath().normalize();
        }

        // Creates storage directories if they do not exist yet.
        void initialize() throws IOException {
            Files.createDirectories(notesDirectory);
            Files.createDirectories(backupsDirectory);
        }

        // Validates a title once and returns the canonical .txt file path in notes storage.
        private Path notePath(String title) {
            return resolveSafe(title, notesDirectory);
        }

        // Validates a title once and returns the canonical .txt file path in backup storage.
        private Path backupPath(String title) {
            return resolveSafe(title, backupsDirectory);
        }

        // Blocks blank names, traversal, separators, and names outside the allowed filename set.
        private static Path resolveSafe(String title, Path directory) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("Title must not be blank.");
            }
            String trimmed = title.trim();
            if (trimmed.equals(".") || trimmed.equals("..")
                    || trimmed.contains("/") || trimmed.contains("\\")
                    || !trimmed.matches("[\\p{L}\\p{N} _.-]+")) {
                throw new IllegalArgumentException("Use letters, numbers, spaces, dots, underscores, or hyphens.");
            }
            Path result = directory.resolve(trimmed + ".txt").normalize();
            if (!result.getParent().equals(directory)) {
                throw new IllegalArgumentException("Title must stay inside the storage directory.");
            }
            return result;
        }

        // Checks whether a note file exists without opening it.
        boolean noteExists(String title) {
            return Files.exists(notePath(title));
        }

        // Writes note text using UTF-8 and truncates only after menu confirmation.
        void createNote(String title, String content) throws IOException {
            try (BufferedWriter writer = Files.newBufferedWriter(notePath(title), StandardCharsets.UTF_8)) {
                writer.write(content);
            }
        }

        // Returns sorted note titles without the .txt suffix.
        java.util.List<String> listNotes() throws IOException {
            try (var files = Files.list(notesDirectory)) {
                return files.filter(Files::isRegularFile)
                        .map(path -> path.getFileName().toString())
                        .filter(name -> name.endsWith(".txt"))
                        .map(name -> name.substring(0, name.length() - 4))
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .toList();
            }
        }

        // Reads and returns the full UTF-8 content of an existing note.
        String readNote(String title) throws IOException {
            Path path = notePath(title);
            if (!Files.isRegularFile(path)) {
                throw new IOException("Note not found: " + title);
            }
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!content.isEmpty()) {
                        content.append(System.lineSeparator());
                    }
                    content.append(line);
                }
            }
            return content.toString();
        }

        // Appends new UTF-8 content while preserving all existing bytes and text.
        void appendNote(String title, String content) throws IOException {
            Path path = notePath(title);
            if (!Files.isRegularFile(path)) {
                throw new IOException("Note not found: " + title);
            }
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path.toFile(), true), StandardCharsets.UTF_8))) {
                if (Files.size(path) > 0) {
                    writer.newLine();
                }
                writer.write(content);
            }
        }

        // Finds case-insensitive keyword matches and includes the file name and line number.
        java.util.List<String> search(String keyword) throws IOException {
            if (keyword == null || keyword.isBlank()) {
                throw new IllegalArgumentException("Keyword must not be blank.");
            }
            java.util.List<String> matches = new java.util.ArrayList<>();
            for (String title : listNotes()) {
                try (BufferedReader reader = Files.newBufferedReader(notePath(title), StandardCharsets.UTF_8)) {
                    String line;
                    int lineNumber = 0;
                    while ((line = reader.readLine()) != null) {
                        lineNumber++;
                        if (line.toLowerCase(java.util.Locale.ROOT)
                                .contains(keyword.toLowerCase(java.util.Locale.ROOT))) {
                            matches.add(title + ".txt:" + lineNumber + ": " + line);
                        }
                    }
                }
            }
            return matches;
        }

        // Deletes a note, reporting a useful error when it does not exist.
        void deleteNote(String title) throws IOException {
            if (!Files.deleteIfExists(notePath(title))) {
                throw new IOException("Note not found: " + title);
            }
        }

        // Copies bytes through a reusable buffer rather than using Files.copy().
        void exportNote(String title) throws IOException {
            Path source = notePath(title);
            Path destination = backupPath(title);
            if (!Files.isRegularFile(source)) {
                throw new IOException("Note not found: " + title);
            }
            try (FileInputStream input = new FileInputStream(source.toFile());
                 FileOutputStream output = new FileOutputStream(destination.toFile())) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
        }

        // Restores a backup only if a note with the same title does not already exist.
        void restoreNote(String title) throws IOException {
            Path source = backupPath(title);
            Path destination = notePath(title);
            if (!Files.isRegularFile(source)) {
                throw new IOException("Backup not found: " + title);
            }
            if (Files.exists(destination)) {
                throw new IOException("Restore refused; note already exists: " + title);
            }
            try (FileInputStream input = new FileInputStream(source.toFile());
                 FileOutputStream output = new FileOutputStream(destination.toFile())) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
        }

        // Reports file size, line count, and last update time for the optional stretch feature.
        String details(String title) throws IOException {
            Path path = notePath(title);
            if (!Files.isRegularFile(path)) {
                throw new IOException("Note not found: " + title);
            }
            long lineCount;
            try (var lines = Files.lines(path, StandardCharsets.UTF_8)) {
                lineCount = lines.count();
            }
            FileTime modified = Files.getLastModifiedTime(path);
            return title + ".txt — " + Files.size(path) + " bytes, "
                    + lineCount + " lines, modified " + modified;
        }
    }
}
