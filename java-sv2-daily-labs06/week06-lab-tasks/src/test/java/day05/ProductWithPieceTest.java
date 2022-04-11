package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductWithPieceTest {

    @Test
    void testCreate() {
        ProductWithPiece pwp = new ProductWithPiece(Type.FRUIT);
        assertEquals(Type.FRUIT, pwp.getType());
        assertEquals(1, pwp.getCount());
    }

    @Test
    void incrementCount() {
        ProductWithPiece pwp = new ProductWithPiece(Type.FRUIT);
        pwp.incrementCount();
        assertEquals(2, pwp.getCount());
    }
}