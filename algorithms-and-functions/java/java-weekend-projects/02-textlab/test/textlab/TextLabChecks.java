package textlab;

// Runs dependency-free acceptance checks for TextLab tokenization and transformations.
public class TextLabChecks {
    // Covers whitespace, whole-word matching, palindrome handling, and punctuation-only input.
    public static void main(String[] args) {
        check(App.TextTools.clean("  Java\t\tJAVA\njava  ").equals("Java JAVA java"),
                "Whitespace cleanup failed.");
        check(App.TextTools.frequency("Java JavaScript JAVA java", "java") == 3,
                "Whole-word, case-insensitive search failed.");
        check(App.TextTools.replaceWord("Java JavaScript JAVA", "java", "JVM")
                .equals("JVM JavaScript JVM"), "Whole-word replacement failed.");
        check(App.TextTools.isPalindrome("A man, a plan, a canal: Panama!"),
                "The Panama palindrome should be recognized.");
        check(App.TextTools.longestWords("... !!! ???").isEmpty(),
                "Punctuation-only text should have no words.");
        check(App.TextTools.firstDifference("same", "samX") == 3,
                "First differing position is incorrect.");
        check(App.TextTools.firstDifference("same", "same") == -1,
                "Identical passages should have no differing position.");
        System.out.println("TextLab checks passed.");
    }

    // Stops the check run at the first incorrect result.
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
