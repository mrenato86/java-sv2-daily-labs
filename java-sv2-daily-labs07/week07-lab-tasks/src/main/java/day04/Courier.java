package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride newRide) {
        if (newRide == null || !isValidSubsequentRide(newRide)) {
            throw new IllegalArgumentException("Invalid subsequent Ride in Courier!");
        }
        rides.add(newRide);
    }

    private boolean isValidSubsequentRide(Ride ride) {
        if (rides.size() == 0) {
            return ride.getNumOfRide() == 1;
        }
        return rides.get(rides.size() - 1).isOneBeforeTo(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(rides.get(0).toString());
        for (int i = 1; i < rides.size(); i++) {
            sb.append("\n").append(rides.get(i));
        }
        return sb.toString();
    }
}
