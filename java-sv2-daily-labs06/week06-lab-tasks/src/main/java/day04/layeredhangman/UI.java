package day04.layeredhangman;

import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        new UI().run();
    }

    private void run() {
        System.out.println("Hangman Game\n");
        Logic logic = new Logic("almafa", 8);
        Scanner scanner = new Scanner(System.in);
        do {
            printStatus(logic);
            String guess = getGuess(scanner);
            if (logic.isRightGuess(guess)) {
                System.out.println("Hit!\n");
            } else {
                System.out.println("Wrong guess!\n");
            }
        } while (!logic.won() && logic.hasMoreChances());
        printResult((logic));

    }

    private void printResult(Logic logic) {
        if (logic.won() && logic.hasMoreChances()) {
            System.out.printf("Victory! The word was: %s\n", logic.getWordFound());
        } else {
            System.out.println("Defeat! The word was: " + logic.getWordToFind());
        }
    }

    private void printStatus(Logic logic) {
        System.out.println("Your Progress:");
        System.out.println(logic.getWordFound());
        System.out.printf("Next guess (%d guess left): ", logic.getChances());
    }

    private String getGuess(Scanner scanner) {
        return scanner.nextLine().substring(0, 1);
    }

}
