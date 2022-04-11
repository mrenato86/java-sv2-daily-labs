package day05;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;

public class StoreMain {

    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Product("milk", LocalDate.of(2020, 11, 4), 1200));
        store.addProduct(new Product("meat", LocalDate.of(2020, 10, 2), 2000));
        store.addProduct(new Product("apple", LocalDate.of(2020, 10, 14), 200));
        store.addProduct(new Product("drink", LocalDate.of(2020, 11, 20), 500));
        store.addProduct(new Product("thing", LocalDate.of(2020, 11, 10), 1200));
        store.addProduct(new Product("dress", LocalDate.of(2020, 8, 11), 5200));

        System.out.println("Results written to:");
        System.out.println(store.writeProductSoldInMonth(Month.NOVEMBER, Path.of("src/main/resources/day05")));
    }

}
