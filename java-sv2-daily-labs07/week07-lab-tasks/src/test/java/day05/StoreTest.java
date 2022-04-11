package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreTest {

    Store store = new Store();
    Product testProductA = new Product("milk", LocalDate.of(2020, 11, 4), 1200);
    Product testProductB = new Product("meat", LocalDate.of(2020, 10, 2), 2000);
    Product testProductC = new Product("apple", LocalDate.of(2020, 10, 14), 200);
    Product testProductD = new Product("drink", LocalDate.of(2020, 11, 20), 500);

    @BeforeEach
    void init() {
        store.addProduct(testProductA);
        store.addProduct(testProductB);
        store.addProduct(testProductC);
        store.addProduct(testProductD);
    }

    @Test
    void testAddProduct() {
        store.addProduct(new Product("test", LocalDate.of(2020, 11, 4), 1000));
        assertEquals(5, store.getProductsSold().size());
    }

    @Test
    void testAddProductWrongDate() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> store.addProduct(new Product("test", LocalDate.of(2030, 11, 4), 1000))
        );
        assertEquals("Date cannot be in the future", iae.getMessage());
    }

    @TempDir
    File temporaryFolder;

    @Test
    void testWriteProductSoldInMonthNovember() throws IOException {

        Path expectedPath = temporaryFolder.toPath().resolve("november.csv");
        Path resultPath = store.writeProductSoldInMonth(Month.NOVEMBER, temporaryFolder.toPath());

        List<String> expectedList = List.of(
                testProductA.toString(),
                testProductD.toString()
        );
        List<String> resultList = Files.readAllLines(expectedPath);

        assertEquals(expectedPath, resultPath);
        assertEquals(expectedList, resultList);
    }
}