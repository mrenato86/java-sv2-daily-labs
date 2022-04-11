package day04.hangman;

import java.util.Scanner;

public class HangmanMain {

    private String wordToFind = "alma";
    private String wordFound = "_".repeat(wordToFind.length());
    private int chances = 8;

    public static void main(String[] args) {
        new HangmanMain().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hangman Game\n");
        do {
            System.out.println("Your Progress:");
            System.out.println(wordFound);
            System.out.printf("Next guess (%d guess left): ", chances);
            String guess = scanner.nextLine().substring(0, 1);
            if (wordToFind.contains(guess)) {
                System.out.println("Hit!\n");
                wordFound = updateWordFound(wordToFind, wordFound, guess);
            } else {
                System.out.println("Wrong guess!\n");
                chances--;
            }
        } while (wordFound.contains("_") && chances > 0);
        if (wordFound.equals(wordToFind) && chances > 0) {
            System.out.printf("Victory with %d wrong guess! The word was: %s\n", 8 - chances, wordFound);
        } else {
            System.out.println("Defeat! The word was: " + wordToFind);
        }

    }

    private String updateWordFound(String wordToFind, String status, String guess) {
        char[] chars = status.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (wordToFind.charAt(i) == guess.charAt(0)) {
                chars[i] = guess.charAt(0);
            }
        }
        return new String(chars);
    }
}
