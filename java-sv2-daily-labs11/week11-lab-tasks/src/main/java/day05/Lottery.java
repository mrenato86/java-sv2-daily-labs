package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private int maxNumber;
    private int numToDraw;

    public Lottery(int maxNumber, int numToDraw) {
        if (numToDraw <= 0 || maxNumber < numToDraw) {
            throw new IllegalArgumentException("Invalid game!");
        }
        this.maxNumber = maxNumber;
        this.numToDraw = numToDraw;
    }

    public List<Integer> startLottery() {
        List<Integer> numbersDrawn = new ArrayList<>(numToDraw);
        Random random = new Random();
        int numbersAdded = 1;
        while (numbersAdded <= numToDraw) {
            int actualNumber = random.nextInt(1, maxNumber + 1);
            if (!numbersDrawn.contains(actualNumber)) {
                numbersDrawn.add(actualNumber);
                numbersAdded++;
            }
        }
        return numbersDrawn;
    }

}
