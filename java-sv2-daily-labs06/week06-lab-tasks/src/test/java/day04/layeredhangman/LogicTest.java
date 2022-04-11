package day04.layeredhangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogicTest {

    @Test
    void testWon() {
        Logic logic = new Logic("aaaa", 8);
        logic.isRightGuess("a");
        assertTrue(logic.won());
    }

    @Test
    void testWonWrongGuess() {
        Logic logic = new Logic("aaaa", 8);
        logic.isRightGuess("b");
        assertFalse(logic.won());
    }
}