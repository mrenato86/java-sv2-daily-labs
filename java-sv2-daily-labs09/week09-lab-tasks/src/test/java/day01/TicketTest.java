package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketTest {

    @Test
    void testCreate() {
        Ticket ticket = new Ticket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000);
        assertEquals("ACDC", ticket.getBandName());
        assertEquals(LocalDateTime.of(2021, 8, 20, 20, 30), ticket.getDateTime());
        assertEquals(8000, ticket.getPrice());
    }

    @Test
    void testEntryTime() {
        Ticket ticket = new Ticket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000);
        LocalTime expected = LocalTime.of(19, 30);

        assertEquals(expected, ticket.entryTime());
    }

}