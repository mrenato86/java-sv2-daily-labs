package day04;

public class GasStation {

    int gasPrice;

    public GasStation(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    public int tank(Car car, int liter) {
        car.setFuel(liter);
        return gasPrice*liter;

    }

}
