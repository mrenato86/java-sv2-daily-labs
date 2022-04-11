package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HikingTest {

    Hiking hiking = new Hiking(21.5, 30.23, 42.1);

    @Test
    void testCreate() {
        Hiking hiking = new Hiking(21.5, 30.23, 42.1);
        assertEquals(21.5, hiking.getLatitude());
        assertEquals(30.23, hiking.getLongitude());
        assertEquals(42.1, hiking.getElevation());
    }

    @Test
    void testGetPlusElevationVariant() {
        List<Double> elevations = List.of(10., 20., 15., 18.);
        assertEquals(13., hiking.getPlusElevation(elevations));
    }

    @Test
    void testGetPlusElevationOnlyPlus() {
        List<Double> elevations = List.of(10., 20., 30., 50.);
        assertEquals(40., hiking.getPlusElevation(elevations));
    }

    @Test
    void testGetPlusElevationOnlyMinus() {
        List<Double> elevations = List.of(50., 30., 20., 10.);
        assertEquals(0., hiking.getPlusElevation(elevations));
    }

    @Test
    void testGetPlusElevationOneOrEmpty() {
        List<Double> elevationsEmpty = List.of();
        assertEquals(0., hiking.getPlusElevation(elevationsEmpty));

        List<Double> elevationsOne = List.of(20.);
        assertEquals(0., hiking.getPlusElevation(elevationsOne));

    }

    @Test
    void testGetPlusElevationNull() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> hiking.getPlusElevation(null));
        assertEquals("Elevations must not be null!", ise.getMessage());
    }
}