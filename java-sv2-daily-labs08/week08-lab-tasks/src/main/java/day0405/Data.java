package day0405;

public class Data {

    private int day;
    private int min;
    private int max;

    public Data(int day, int min, int max) {
        this.day = day;
        this.min = min;
        this.max = max;
    }

    public int getDay() {
        return day;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSpread() {
        return Math.abs(max - min);
    }
}
