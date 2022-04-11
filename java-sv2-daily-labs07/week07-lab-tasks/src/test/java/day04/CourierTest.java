package day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourierTest {

    Ride rideLastDay = new Ride(2, 1, 19);
    Ride baseRide = new Ride(4, 1, 19);
    Ride rideOneAfter = new Ride(4, 2, 19);
    Ride rideTwoAfter = new Ride(4, 3, 19);

    Courier courier = new Courier();

    @Test
    void testCreate() {
        Courier courier = new Courier();

        assertEquals(0, courier.getRides().size());
    }

    @Test
    void testAddRideSuccess() {
        List<Ride> expected = List.of(rideLastDay, baseRide, rideOneAfter, rideTwoAfter);

        courier.addRide(rideLastDay);
        courier.addRide(baseRide);
        courier.addRide(rideOneAfter);
        courier.addRide(rideTwoAfter);

        assertEquals(expected, courier.getRides());
    }

    @Test
    void testAddRideExceptionWrongFirst() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(rideOneAfter));
        assertEquals("Invalid subsequent Ride in Courier!", iae.getMessage());
        assertEquals(0, courier.getRides().size());
    }

    @Test
    void testAddRideExceptionWrongOrderDay() {
        courier.addRide(baseRide);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(rideLastDay));
        assertEquals("Invalid subsequent Ride in Courier!", iae.getMessage());
        assertEquals(1, courier.getRides().size());
    }

    @Test
    void testAddRideExceptionWrongOrderRideNewDay() {
        courier.addRide(rideLastDay);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(rideOneAfter));
        assertEquals("Invalid subsequent Ride in Courier!", iae.getMessage());
        assertEquals(1, courier.getRides().size());
    }

    @Test
    void testAddRideExceptionWrongOrderRideSameDay() {
        courier.addRide(baseRide);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(rideTwoAfter));
        assertEquals("Invalid subsequent Ride in Courier!", iae.getMessage());

        iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(baseRide));
        assertEquals("Invalid subsequent Ride in Courier!", iae.getMessage());

        assertEquals(1, courier.getRides().size());
    }

}