package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;

class PersonTest {

    @Test
    void testCreate() {
        Ticket ticket = new Ticket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000);
        Person person = new Person(ticket);
        assertSame(ticket, person.getTicket());
    }

}