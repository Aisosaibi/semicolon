package textlab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Provides a console menu for inspecting and editing a passage.
public class App {
    // Reads a multi-line passage once, preserves it, and applies operations to an edited copy.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your passage; type a single . on a line to finish:");
        StringBuilder collected = new StringBuilder();
        while (true) {
            String line = input.nextLine();
            if (line.equals(".")) {
                break;
            }
            if (!collected.isEmpty()) {
                collected.append('\n');
            }
            collected.append(line);
        }
        String original = collected.toString();
        String edited = original;
        boolean running = true;
        while (running) {
            System.out.println("\nTextLab — 1 Counts | 2 Clean | 3 Search | 4 Replace");
            System.out.println("5 Palindrome | 6 Longest words | 7 Compare | 8 Show text | 0 Exit");
            System.out.print("Choice: ");
            switch (input.nextLine().trim()) {
                case "1" -> System.out.println(TextTools.counts(edited));
                case "2" -> {
                    edited = TextTools.clean(edited);
                    System.out.println("Whitespace cleaned.");
                }
                case "3" -> {
                    System.out.print("Whole word to find: ");
                    System.out.println("Occurrences: " + TextTools.frequency(edited, input.nextLine()));
                }
                case "4" -> {
                    System.out.print("Whole word to replace: ");
                    String target = input.nextLine();
                    System.out.print("Replacement: ");
                    edited = TextTools.replaceWord(edited, target, input.nextLine());
                    System.out.println("Replacement complete.");
                }
                case "5" -> System.out.println(TextTools.isPalindrome(edited)
                        ? "The passage is a palindrome." : "The passage is not a palindrome.");
                case "6" -> System.out.println("Longest word(s): " + TextTools.longestWords(edited));
                case "7" -> System.out.println("First difference: "
                        + TextTools.firstDifference(original, edited));
                case "8" -> {
                    System.out.println("Original:\n" + original);
                    System.out.println("Edited:\n" + edited);
                }
                case "0" -> running = false;
                default -> System.out.println("Choose a listed menu number.");
            }
        }
        System.out.println("Goodbye.");
    }

    // Contains pure text operations so they can be checked without console input.
    static final class TextTools {
        private static final Pattern WORDS = Pattern.compile("[\\p{L}\\p{N}]+");
        private static final Pattern SENTENCE_END = Pattern.compile("[.!?]+");
        private static final Pattern WHITESPACE = Pattern.compile("\\s+");

        // Reports code-unit count, non-whitespace code-unit count, token count, and sentence count.
        static String counts(String text) {
            long nonWhitespace = text.chars().filter(character -> !Character.isWhitespace(character)).count();
            int wordCount = words(text).size();
            int sentenceCount = sentences(text);
            return "Characters (including whitespace): " + text.length()
                    + "\nCharacters (excluding whitespace): " + nonWhitespace
                    + "\nWords: " + wordCount + "\nSentences: " + sentenceCount;
        }

        // Trims the passage and collapses every whitespace run to one ordinary space.
        static String clean(String text) {
            return WHITESPACE.matcher(text).replaceAll(" ").trim();
        }

        // Counts exact word tokens without regard to case, so Java never matches JavaScript.
        static int frequency(String text, String target) {
            if (!isSingleWord(target)) {
                return 0;
            }
            int count = 0;
            for (String word : words(text)) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
            return count;
        }

        // Replaces case-insensitive whole-word matches while preserving punctuation around them.
        static String replaceWord(String text, String target, String replacement) {
            if (!isSingleWord(target)) {
                return text;
            }
            Pattern targetPattern = Pattern.compile("(?<![\\p{L}\\p{N}])"
                    + Pattern.quote(target) + "(?![\\p{L}\\p{N}])",
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = targetPattern.matcher(text);
            StringBuilder result = new StringBuilder();
            while (matcher.find()) {
                matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
            }
            matcher.appendTail(result);
            return result.toString();
        }

        // Ignores all characters except letters and digits, then compares with the reversed form.
        static boolean isPalindrome(String text) {
            StringBuilder normalized = new StringBuilder();
            text.codePoints().filter(Character::isLetterOrDigit)
                    .forEach(normalized::appendCodePoint);
            return normalized.toString().equalsIgnoreCase(normalized.reverse().toString());
        }

        // Returns the distinct longest tokens in first-occurrence order.
        static List<String> longestWords(String text) {
            Map<String, String> longest = new LinkedHashMap<>();
            int maxLength = 0;
            for (String word : words(text)) {
                int length = word.codePointCount(0, word.length());
                if (length > maxLength) {
                    maxLength = length;
                    longest.clear();
                }
                if (length == maxLength) {
                    longest.putIfAbsent(word.toLowerCase(java.util.Locale.ROOT), word);
                }
            }
            return new ArrayList<>(longest.values());
        }

        // Returns the first differing UTF-16 index, or the shared length if one is a prefix.
        static int firstDifference(String first, String second) {
            int sharedLength = Math.min(first.length(), second.length());
            for (int index = 0; index < sharedLength; index++) {
                if (first.charAt(index) != second.charAt(index)) {
                    return index;
                }
            }
            return first.length() == second.length() ? -1 : sharedLength;
        }

        // Splits on sentence punctuation and counts only fragments that contain a word.
        private static int sentences(String text) {
            int count = 0;
            for (String fragment : SENTENCE_END.split(text)) {
                if (!words(fragment).isEmpty()) {
                    count++;
                }
            }
            return count;
        }

        // Extracts each maximal letter-or-digit sequence as one word.
        private static List<String> words(String text) {
            List<String> result = new ArrayList<>();
            Matcher matcher = WORDS.matcher(text);
            while (matcher.find()) {
                result.add(matcher.group());
            }
            return result;
        }

        // Ensures replacement and search targets follow the documented word-token rule.
        private static boolean isSingleWord(String text) {
            return text != null && WORDS.matcher(text).matches();
        }
    }
}
