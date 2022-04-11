package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTest {

    @Test
    void testCreate() {
        Human human = new Human("John Doe", 1988);
        assertEquals("John Doe", human.getName());
        assertEquals(1988, human.getYearOfBirth());
    }

    @Test
    void testCreateWrongName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human("JohnDoe", 1988));
        assertEquals("Name must contain two parts!", iae.getMessage());
    }

    @Test
    void testCreateNullName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human(null, 1988));
        assertEquals("Name must contain two parts!", iae.getMessage());
    }

    @Test
    void testCreateWrongBirth() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human("John Doe", 1900));
        assertEquals("Age must be below 120!", iae.getMessage());
    }

}