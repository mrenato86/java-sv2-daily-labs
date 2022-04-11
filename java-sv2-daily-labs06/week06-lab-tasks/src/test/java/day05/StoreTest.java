package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class StoreTest {

    Store store = new Store();

    @BeforeEach
    void init() {
        store.addProduct(new Product("Milk", Type.DAIRY, 0.7));
        store.addProduct(new Product("Butter", Type.DAIRY, 2.3));
    }

    @Test
    void testAddProduct() {
        Product product = new Product("Grape", Type.FRUIT, 0.5);
        store.addProduct(product);
        assertEquals(3, store.getProducts().size());
        assertSame(product, store.getProducts().get(2));
    }

    @Test
    void testNumberOfProductsByOneType() {
        List<ProductWithPiece> result = store.numberOfProductsByType();

        assertEquals(1, result.size());
        assertEquals(Type.DAIRY, result.get(0).getType());
        assertEquals(2, result.get(0).getCount());
    }

    @Test
    void testNumberOfProductsByManyType() {
        store.addProduct(new Product("Grape", Type.FRUIT, 0.5));
        store.addProduct(new Product("Apple", Type.FRUIT, 0.3));
        List<ProductWithPiece> result = store.numberOfProductsByType();

        assertEquals(2, result.size());
        assertEquals(Type.DAIRY, result.get(0).getType());
        assertEquals(Type.FRUIT, result.get(1).getType());
        assertEquals(2, result.get(0).getCount());
        assertEquals(2, result.get(1).getCount());
    }

    @Test
    void testNumberOfProductsByTypeEmpty() {
        Store store = new Store();
        List<ProductWithPiece> result = store.numberOfProductsByType();

        assertEquals(0, result.size());
    }
}