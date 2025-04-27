import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int totalRounds = 0;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempt(s).");
                    System.out.println("🏆 Score this round: " + score + " points.");
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've run out of attempts! The number was: " + targetNumber);
            }

            totalRounds++;
            System.out.print("\nWould you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Final summary
        System.out.println("\n🎮 Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Score: " + totalScore + " points");

        scanner.close();
    }
}