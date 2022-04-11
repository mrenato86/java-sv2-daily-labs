package day04;

public class Ride {

    private final int numOfDay;
    private final int numOfRide;
    private final int km;

    public Ride(int numOfDay, int numOfRide, int km) {
        if (numOfDay < 1 || numOfDay > 7 || numOfRide < 1 || km < 0) {
            throw new IllegalArgumentException("Invalid Ride information!");
        }
        this.numOfDay = numOfDay;
        this.numOfRide = numOfRide;
        this.km = km;
    }

    public int getNumOfDay() {
        return numOfDay;
    }

    public int getNumOfRide() {
        return numOfRide;
    }

    public int getKm() {
        return km;
    }

    public boolean isOneBeforeTo(Ride otherRide) {
        if (otherRide == null) {
            return false;
        }
        if (this.numOfDay < otherRide.numOfDay) {
            return otherRide.numOfRide == 1;
        }
        return this.numOfDay == otherRide.numOfDay && otherRide.numOfRide == this.numOfRide + 1;
    }

    @Override
    public String toString() {
        return numOfDay + " " + numOfRide + " " + km;
    }
}
