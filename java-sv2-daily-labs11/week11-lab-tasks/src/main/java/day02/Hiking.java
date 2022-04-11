package day02;

import java.util.List;

public class Hiking {

    private double latitude;
    private double longitude;
    private double elevation;

    public Hiking(double latitude, double longitude, double elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public double getPlusElevation(List<Double> elevations) {
        if (elevations == null) {
            throw new IllegalStateException("Elevations must not be null!");
        }
        double sumOfElevation = 0;
        for (int i = 1; i < elevations.size(); i++) {
            double actualElevation = elevations.get(i) - elevations.get(i - 1);
            if (actualElevation > 0) {
                sumOfElevation += actualElevation;
            }
        }
        return sumOfElevation;
    }
}
