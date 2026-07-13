import java.util.Random;
import java.util.Scanner;

public class NumberGettingApp {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int countGuesses = 0;
        int correctGuess = rand.nextInt(100) + 1;
        int guess = 0;
        boolean isGuessCorrect = false;
        String rating = "Better luck";

        System.out.println("Guess a number between 1 and 100. You have 5 attempts.");

        while (countGuesses < 5) {
            System.out.print("Guess: ");

            // Validate input
            while (!scanner.hasNextInt() || (guess = scanner.nextInt()) < 1 || guess > 100) {
                System.out.println("Invalid input. Enter a number between 1 and 100: ");
                if (!scanner.hasNextInt()) scanner.next();
            }

            countGuesses++;

            if (guess == correctGuess) {
                isGuessCorrect = true;
                switch (countGuesses) {
                    case 1: rating = "Legendary"; break;
                    case 2: rating = "Excellent"; break;
                    case 3:
                    case 4: rating = "Good"; break;
                    case 5: rating = "Close!"; break;
                }
                break;
            } else if (guess > correctGuess) {
                System.out.println("Too high! Guess again.");
            } else {
                System.out.println("Too low! Guess again.");
            }
        }

        if (isGuessCorrect) {
            System.out.printf("Correct! The number was: %d%nAttempts used: %d%nRating: %s%n",
                correctGuess, countGuesses, rating);
        } else {
            System.out.printf("Out of attempts! The number was: %d%n", correctGuess);
        }

        scanner.close();
    }
}
