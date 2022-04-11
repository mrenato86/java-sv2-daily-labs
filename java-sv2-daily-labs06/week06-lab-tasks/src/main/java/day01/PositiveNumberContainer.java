package day01;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumberContainer {

    private final List<Double> numbers = new ArrayList<>();

    public void addNumber(double number) {
        numbers.add(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
