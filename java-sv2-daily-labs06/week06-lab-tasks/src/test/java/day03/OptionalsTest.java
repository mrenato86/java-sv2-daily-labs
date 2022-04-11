package day03;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalsTest {

    Optionals optionals = new Optionals();

    @Test
    void getRandomOddNumbers() {
        assertArrayEquals(new int[]{89, 13, 37, 59, 17}, optionals.getRandomOddNumbers(new Random(50), 5));

    }

    @Test
    void testRoundPositive() {
        assertEquals(10, optionals.round(11));
        assertEquals(10, optionals.round(12));
        assertEquals(15, optionals.round(13));
        assertEquals(15, optionals.round(14));
        assertEquals(15, optionals.round(15));
        assertEquals(15, optionals.round(16));
        assertEquals(15, optionals.round(17));
        assertEquals(20, optionals.round(18));
        assertEquals(20, optionals.round(19));
        assertEquals(0, optionals.round(0));
    }

    @Test
    void testRoundNegative() {
        assertEquals(-10, optionals.round(-11));
        assertEquals(-10, optionals.round(-12));
        assertEquals(-15, optionals.round(-13));
        assertEquals(-15, optionals.round(-14));
        assertEquals(-15, optionals.round(-15));
        assertEquals(-15, optionals.round(-16));
        assertEquals(-15, optionals.round(-17));
        assertEquals(-20, optionals.round(-18));
        assertEquals(-20, optionals.round(-19));
    }
}