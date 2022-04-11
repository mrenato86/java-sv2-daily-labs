package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConcertTest {

    Ticket ticket = new Ticket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000);
    Concert concert = new Concert();

    @Test
    void testAddPerson() {
        concert.addPerson(new Person(ticket), LocalTime.of(19, 45));

        assertEquals(1, concert.getAttendees().size());
    }

    @Test
    void testAddPersonException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> concert.addPerson(new Person(ticket), LocalTime.of(19, 20))
        );
        assertEquals("Not a valid entrance", iae.getMessage());
    }
}