package day03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    private int rangeMin;
    private int rangeMax;
    private int numOfTrials;

    public GuessTheNumber() {
        this(1, 99, 6);
    }

    public GuessTheNumber(int rangeMin, int rangeDelta, int numOfTrials) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMin + rangeDelta;
        this.numOfTrials = numOfTrials;
    }

    public void startWithRandom() {
        Random random = new Random();
        int number = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;

        guess(number);
    }

    public void startWithRandomSeed(int seed) {
        Random random = new Random(seed);
        int number = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;

        guess(number);
    }

    public void startWithPreset(int number) {
        if (rangeMin <= number && number <= rangeMax) {
            guess(number);
        }
    }

    private void guess(int number) {
        System.out.println("Number selected from pool " + rangeMin + "-" + rangeMax + ", guess " + numOfTrials + " times!");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numOfTrials; i++) {
            System.out.print((i + 1) + ". guess: ");
            int guess = scanner.nextInt();
            if (guess == number) {
                System.out.println("Congratulations! Your guess is right: " + guess);
                return;
            }
            if (guess < number) {
                System.out.println("The number is greater than " + guess);
            } else {
                System.out.println("The number is smaller than " + guess);
            }
        }
        System.out.println("Out of guesses, the number was " + number);
    }

    public void setRange(int rangeMin, int rangeDelta) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMin + rangeDelta;
    }

    public void setNumOfTrials(int numOfTrials) {
        this.numOfTrials = numOfTrials;
    }

    public int getRangeMin() {
        return rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public int getNumOfTrials() {
        return numOfTrials;
    }
}
