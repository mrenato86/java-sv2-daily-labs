package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrontOfStageTicketTest {

    @Test
    void testCreate() {
        FrontOfStageTicket frontTicket = new FrontOfStageTicket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000, "C1234");
        assertEquals("ACDC", frontTicket.getBandName());
        assertEquals(LocalDateTime.of(2021, 8, 20, 20, 30), frontTicket.getDateTime());
        assertEquals(8000, frontTicket.getPrice());
        assertEquals("C1234", frontTicket.getExtraCode());
    }

    @Test
    void testEntryTime() {
        FrontOfStageTicket frontTicket = new FrontOfStageTicket("ACDC", LocalDateTime.of(2021, 8, 20, 20, 30), 8000, "C1234");
        LocalTime expected = LocalTime.of(18, 30);

        assertEquals(expected, frontTicket.entryTime());
    }
}