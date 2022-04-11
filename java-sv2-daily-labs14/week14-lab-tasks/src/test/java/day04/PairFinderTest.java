package day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairFinderTest {

    @Test
    void testFindPairs() {
        int[] numbers = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, new PairFinder().findPairs(numbers));
    }

    @Test
    void testFindPairsNoPair() {
        int[] numbers = {7, 1, 5, 3, 6};
        assertEquals(0, new PairFinder().findPairs(numbers));
    }

    @Test
    void testFindPairsStream() {
        int[] numbers = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, new PairFinder().findPairsStream(numbers));
    }

    @Test
    void testFindPairsStreamNoPair() {
        int[] numbers = {7, 1, 5, 3, 6};
        assertEquals(0, new PairFinder().findPairsStream(numbers));
    }

    @Test
    void testFindPairsStreamList() {
        List<Integer> numbers = List.of(7, 1, 5, 7, 3, 3, 5, 7, 6, 7);
        assertEquals(4, new PairFinder().findPairsStreamList(numbers));
    }

    @Test
    void testFindPairsStreamListNoPair() {
        List<Integer> numbers = List.of(7, 1, 5, 3, 6);
        assertEquals(0, new PairFinder().findPairsStreamList(numbers));
    }

}