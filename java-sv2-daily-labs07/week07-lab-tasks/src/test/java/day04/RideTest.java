package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride rideLastDay = new Ride(2, 3, 19);
    Ride baseRide = new Ride(4, 1, 19);
    Ride rideOneAfter = new Ride(4, 2, 19);
    Ride rideTwoAfter = new Ride(4, 3, 19);

    @Test
    void testCreate() {
        Ride ride = new Ride(4, 1, 19);

        assertEquals(4, ride.getNumOfDay());
        assertEquals(1, ride.getNumOfRide());
        assertEquals(19, ride.getKm());
    }

    @Test
    void testCreateWrongData() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Ride(9, 1, 19));
        assertEquals("Invalid Ride information!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class, () -> new Ride(4, 0, 19));
        assertEquals("Invalid Ride information!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class, () -> new Ride(4, 1, -3));
        assertEquals("Invalid Ride information!", iae.getMessage());
    }


    @Test
    void testIsOneBeforeToTrue() {
        assertTrue(rideLastDay.isOneBeforeTo(baseRide));
        assertTrue(baseRide.isOneBeforeTo(rideOneAfter));
        assertTrue(rideOneAfter.isOneBeforeTo(rideTwoAfter));
    }

    @Test
    void testIsOneBeforeToFalse() {
        assertFalse(rideLastDay.isOneBeforeTo(rideOneAfter));
        assertFalse(baseRide.isOneBeforeTo(rideTwoAfter));
        assertFalse(baseRide.isOneBeforeTo(rideLastDay));
        assertFalse(baseRide.isOneBeforeTo(baseRide));
    }
}