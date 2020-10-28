import java.io.Console;
import java.util.Scanner;

public class Hangman {
    public static void main(String argv[])
    {
        // Create an array of words
        String words[] = {
                "inexhaustible",
                "dauntless",
                "ceaselessly",
                "magniloquent"
        };

        // Pick a random word
        String word = words[(int) (Math.random() * words.length)];

        // Set up the answer array
        String[] answerArray = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            answerArray[i] = "_";
        }

        int remainingLetters = word.length();
        int remainingTries = (int) (word.length() * 1.2);

        Scanner scanner = new Scanner(System.in);
        // The game loop
        while (remainingLetters > 0 && remainingTries > 0) {
            // Show the player their progress
            System.out.println(String.join(" ",answerArray) + "\nRemaining tries = " + remainingTries);
            System.out.print("Please guess a letter:");

            // Get a guess from the player
            String guess = scanner.nextLine();
            if (guess == null) {
                // Exit the game loop
                break;
            } else if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
            } else {
                // Update the game state with the guess
                for (int j = 0; j < word.length(); j++) {
                    if (word.substring(j,j + 1).equals(guess)) {
                        answerArray[j] = guess;
                        remainingLetters--;
                    }
                }
            }
            remainingTries--;
            // The end of the game loop
        }
        if (remainingTries == 0) {
            System.out.println("Mission failed! The answer was " + word);

        } else {
            // Show the answer and congratulate the player
            System.out.println(String.join(" ", answerArray));
            System.out.println("Good job! The answer was " + word);
        }
    }
}
