package day04;

public class GasMain {

    public static void main(String[] args) {
        Car car = new Car();
        GasStation gs = new GasStation(350);

        car.setFuel(60);
        car.setKm(400);

        System.out.println(car.averageConsumption());
        System.out.println(gs.tank(car,50));
        System.out.println(car.averageConsumption());
    }

}
