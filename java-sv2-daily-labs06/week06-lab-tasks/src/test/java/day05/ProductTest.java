package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testCreate() {
        Product product = new Product("Grape", Type.FRUIT, 0.5);
        assertEquals("Grape", product.getName());
        assertEquals(Type.FRUIT, product.getType());
        assertEquals(0.5, product.getPrice());
    }

}