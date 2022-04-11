package day0405.refactored;

public class DataGeneral {

    private String id;
    private int firstValue;
    private int secondValue;

    public DataGeneral(String id, int firstValue, int secondValue) {
        this.id = id;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public String getId() {
        return id;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public int getDifference() {
        return Math.abs(secondValue - firstValue);
    }
}
