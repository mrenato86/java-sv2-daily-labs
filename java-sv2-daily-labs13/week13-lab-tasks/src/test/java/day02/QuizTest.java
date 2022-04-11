package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz(Path.of("src/test/resources/result.txt"));

    @Test
    void testCreate() {
        assertEquals(4, quiz.getPlayerAnswers().size());
        assertEquals("ACCBX", quiz.getPlayerAnswers().get("AB123"));
        assertEquals("ABACD", quiz.getCorrectAnswers());
    }

    @Test
    void testIsCorrectAnswer() {
        assertTrue(quiz.isCorrectAnswer("AB123", 1));
        assertFalse(quiz.isCorrectAnswer("AB123", 2));
    }

    @Test
    void testGetWinner() {
        assertEquals("GH1234", quiz.getWinner());
    }

}