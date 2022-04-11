package day02.cars;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private String name;
    private int priceLimit;
    private final List<Car> carsForSell = new ArrayList<>();

    public CarShop(String name, int priceLimit) {
        this.name = name;
        this.priceLimit = priceLimit;
    }

    public String getName() {
        return name;
    }

    public int getPriceLimit() {
        return priceLimit;
    }

    public List<Car> getCarsForSell() {
        return new ArrayList<>(carsForSell);
    }

    public boolean addCar(Car car) {
        if (car != null && car.getPrice() <= priceLimit) {
            return carsForSell.add(car);
        }
        return false;
    }

    public int sumCarPrice() {
        int sumOfPrices = 0;
        for (Car car : carsForSell) {
            sumOfPrices += car.getPrice();
        }
        return sumOfPrices;
    }

    public int numberOfCarsCheaperThan(int price) {
        int numberOfCheaperCars = 0;
        for (Car car : carsForSell) {
            if (car.getPrice() <= price) {
                numberOfCheaperCars++;
            }
        }
        return numberOfCheaperCars;
    }

    public List<Car> carsWithBrand(String brand) {
        List<Car> carsWithBrand = new ArrayList<>();
        for (Car car : carsForSell) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                carsWithBrand.add(car);
            }
        }
        return carsWithBrand;
    }
}
