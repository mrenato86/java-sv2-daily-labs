package day03;

import java.util.Random;

public class Optionals {

    public int[] getRandomOddNumbers(Random random, int length) {
        int[] numbers = new int[length];
        int count = 0;
        while (count < numbers.length) {
            int num = random.nextInt(1, 101);
            if (num % 2 != 0) {
                numbers[count] = num;
                count++;
            }
        }
        return numbers;
    }

    public int round(int amount) {
        int number = Math.abs(amount);
        int delta = number % 5;
        number += (delta < 3) ? -delta : 5 - delta;
        return (amount < 0) ? -number : number;
    }

}
