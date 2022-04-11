package day03;

public class GuessTheNumberTest {

    public static void main(String[] args) {

        GuessTheNumber game;

        System.out.println("Default game");
        game = new GuessTheNumber();
        game.startWithRandom();
        System.out.println();

        System.out.println("Game with preset number 53");
        game = new GuessTheNumber();
        game.startWithPreset(53);
        System.out.println();

        System.out.println("Game with custom setup");
        game = new GuessTheNumber(100, 200, 9);
        game.startWithRandom();
    }

}
