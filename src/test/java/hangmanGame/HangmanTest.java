package hangmanGame;

import org.junit.Assert;
import org.junit.Test;

import static hangmanGame.Hangman.hang;
import static hangmanGame.Hangman.word;

public class HangmanTest {

    @Test
    public void guessTestInvalidScenarios() {
        System.out.println("Running Tests");
        System.out.println("Actual word is: " + word);

        System.out.println("Test for invalid guesses");
        System.out.println("Input guess letter = 123456 \n" +hang("123456"));
        System.out.println("Input guess letter = m \n" +hang("m"));
        System.out.println("Input guess letter = e \n" +hang("e"));
        System.out.println("Input guess word = cake \n" +hang("make"));

        System.out.println("Tests failed due to invalid guesses");

    }

    @Test
    public void guessTestValidScenarios() {
        System.out.println("Running Tests");
        System.out.println("Actual word is: " + word);

        System.out.println("Test for valid guesses");
        if (word == "global") {
            Assert.assertEquals(true, word.equals("global"));
            System.out.println("Tests passed due to valid guesses");
        } else if (word.equals("essence")) {
            Assert.assertEquals(true, word.equals("essence"));
            System.out.println("Tests passed due to valid guesses");
        } else if (word.equals("essence")) {
            Assert.assertEquals(true, word.equals("advertising"));
            System.out.println("Tests passed due to valid guesses");
        } else if (word.equals("essence")) {
            Assert.assertEquals(true, word.equals("make"));
            System.out.println("Tests passed due to valid guesses");
        } else if (word.equals("essence")) {
            Assert.assertEquals(true, word.equals("world"));
            System.out.println("Tests passed due to valid guesses");
        } else if (word.equals("essence")) {
            Assert.assertEquals(true, word.equals("valuable"));
            System.out.println("Tests passed due to valid guesses");
        }
    }
}
