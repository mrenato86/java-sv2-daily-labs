package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathAlgorithmsTest {

    MathAlgorithms ma = new MathAlgorithms();

    @Test
    void testGcdBruteForce() {
        assertEquals(6, ma.gcdBruteForce(12, 18));
        assertEquals(5, ma.gcdBruteForce(10, 5));
        assertEquals(16, ma.gcdBruteForce(48, 80));
        assertEquals(1, ma.gcdBruteForce(25, 9));
    }

    @Test
    void testGcdEuclideanRecursion() {
        assertEquals(6, ma.gcdEuclideanRecursion(12, 18));
        assertEquals(5, ma.gcdEuclideanRecursion(10, 5));
        assertEquals(16, ma.gcdEuclideanRecursion(48, 80));
        assertEquals(1, ma.gcdEuclideanRecursion(25, 9));
    }

    @Test
    void testGcdEuclideanDivision() {
        assertEquals(6, ma.gcdEuclideanDivision(12, 18));
        assertEquals(5, ma.gcdEuclideanDivision(10, 5));
        assertEquals(16, ma.gcdEuclideanDivision(48, 80));
        assertEquals(1, ma.gcdEuclideanDivision(25, 9));
    }

    @Test
    void testGcdEuclideanSubtraction() {
        assertEquals(6, ma.gcdEuclideanSubtraction(12, 18));
        assertEquals(5, ma.gcdEuclideanSubtraction(10, 5));
        assertEquals(16, ma.gcdEuclideanSubtraction(48, 80));
        assertEquals(1, ma.gcdEuclideanSubtraction(25, 9));
    }
}