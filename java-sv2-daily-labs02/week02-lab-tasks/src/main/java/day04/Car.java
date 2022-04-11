package day04;

public class Car {

    private int fuel;
    private int km;

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getFuel() {
        return fuel;
    }

    public int getKm() {
        return km;
    }

    public double averageConsumption(){
        return (fuel/(double)km)*100;
    }


}
