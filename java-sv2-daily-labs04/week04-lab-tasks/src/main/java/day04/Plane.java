package day04;

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private int maxCapacity;
    private List<Passenger> passengers = new ArrayList<>();

    public Plane(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < maxCapacity) {
            return passengers.add(passenger);
        }
        return false;
    }

    public int numberOfPackages() {
        int sum = 0;
        for (Passenger passenger : passengers) {
            sum += passenger.getNumOfPackage();
        }
        return sum;
    }

}
