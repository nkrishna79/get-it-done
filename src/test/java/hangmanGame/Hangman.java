package hangmanGame;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static String[] words = {"essence", "global", "advertising", "make", "valuable", "world"};
    private static String word = words[(int) (Math.random() * words.length)];
    private static String dashes = new String(new char[word.length()]).replace("\0", "-");
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (count < 9 && dashes.contains("-")) {
            System.out.println("/n" +
                    "Game Rules: " +
                    "1) When the game starts the player can see how many characters the word has.\n" +
                    "2) The player can guess up to 9 times if a letter appears in the secret word.\n" +
                    "   If the letter is in the word then the place of the character is shown to the player.\n" +
                    "   Over the span of the game the incomplete word will appear to the player.\n" +
                    "3) At any stage player can propose a word. Each proposal reduces the number of attempts by one.\n" +
                    "4) The player wins if he can find the secret word within the guess limit. Otherwise the game is lost.");
            Thread.sleep(10000);
            System.out.println("Guess any letter in the word");
            System.out.println(dashes);
            String guess = sc.next();
            hang(guess);
        }
        sc.close();
    }


    public static void hang(String guess) {
        String newdashes = "";
        if(guess.length() > 1){
            if(guess.equals(word)){
                count++;
                newdashes = word;
            }else{
                count++;
                newdashes = dashes;
            }
        }else{
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) {
                    newdashes += guess.charAt(0);
                } else if (dashes.charAt(i) != '-') {
                    newdashes += word.charAt(i);
                } else {
                    newdashes += "-";
                }
            }
        }

        if (dashes.equals(newdashes)) {
            count++;
            hangmanTrial();
        } else {
            dashes = newdashes;
        }
        if (dashes.equals(word)) {
            System.out.println("Correct! You win! The word was " + word);
        }
    }


    public static void hangmanTrial() {
        if (count == 1) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 7) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 8) {
            System.out.println("Wrong guess, try again");
        }
        if (count == 9) {
            System.out.println("GAME OVER!");
            System.out.println("GAME OVER! The word was " + word);
        }
    }
}
