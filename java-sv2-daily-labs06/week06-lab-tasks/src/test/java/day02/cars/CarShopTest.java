package day02.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarShopTest {

    CarShop carShop = new CarShop("Best Car", 10_000_000);

    @BeforeEach
    void init() {
        carShop.addCar(new Car("Toyota", 1.2, Color.BLACK, 2_300_000));
        carShop.addCar(new Car("Suzuki", 1.4, Color.RED, 1_500_000));
        carShop.addCar(new Car("Toyota", 1.4, Color.GREY, 2_700_000));
    }

    @Test
    void createCarShopTest() {
        CarShop carShop = new CarShop("Best Car", 10_000_000);

        assertEquals("Best Car", carShop.getName());
        assertEquals(10_000_000, carShop.getPriceLimit());
        assertEquals(0, carShop.getCarsForSell().size());
    }

    @Test
    void addCarTest() {
        assertTrue(carShop.addCar(new Car("Opel", 1.2, Color.BLACK, 2_500_000)));
        assertEquals(4, carShop.getCarsForSell().size());
        assertEquals("Opel", carShop.getCarsForSell().get(3).getBrand());

        assertFalse(carShop.addCar(new Car("Lamborghini", 5.2, Color.BLACK, 10_300_000)));
        assertEquals(4, carShop.getCarsForSell().size());
    }

    @Test
    void sumCarPriceTest() {
        assertEquals(6_500_000, carShop.sumCarPrice());
    }

    @Test
    void numberOfCarsCheaperThanTest() {
        assertEquals(3, carShop.numberOfCarsCheaperThan(3_000_000));
        assertEquals(1, carShop.numberOfCarsCheaperThan(2_000_000));
        assertEquals(0, carShop.numberOfCarsCheaperThan(1_000_000));
    }

    @Test
    void carsWithBrandTest() {
        assertEquals(2, carShop.carsWithBrand("Toyota").size());
        assertEquals(1, carShop.carsWithBrand("Suzuki").size());
        assertEquals(0, carShop.carsWithBrand("BMW").size());
    }
}