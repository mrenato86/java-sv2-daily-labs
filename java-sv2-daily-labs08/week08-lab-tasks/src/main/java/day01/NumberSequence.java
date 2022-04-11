package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    private List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int number, int min, int max) {
        numbers = new ArrayList<>(number);
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            numbers.add(random.nextInt(min, max + 1));
        }
    }

    private double getAverage() {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalStateException("Cannot calculate average for empty list!");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public List<Integer> closeToAverage(int value) {
        List<Integer> closeToAverage = new ArrayList<>();
        double avg = getAverage();
        for (int number : numbers) {
            if (Math.abs(avg - number) <= value) {
                closeToAverage.add(number);
            }
        }
        return closeToAverage;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
