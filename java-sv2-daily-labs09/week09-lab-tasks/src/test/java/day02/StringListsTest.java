package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListsTest {

    @Test
    void testShortestWords() {
        List<String> words = List.of("aaa", "aa", "bb", "cccc", "dd");
        List<String> expected = List.of("aa", "bb", "dd");

        assertEquals(expected, new StringLists().shortestWords(words));
    }
}