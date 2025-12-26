package org.group_1.terrain_petanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Coordinates entity.
 */
public class CoordinatesTest {

    /**
     * This method tests the obtainCoordinates method.
     */
    @Test
    public void obtainCoordinatesTest() {
        // Init & test
        Coordinates test = Coordinates.obtainCoordinates(100);

        // Assertion
        assertEquals(test.getId(), 100);
    }

    

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        assertThrows(NullPointerException.class, () -> {
            new Coordinates("100", null);
        });

        assertThrows(NullPointerException.class, () -> {
            new Coordinates(null, "120");
        });
    }


    
    /**
     * This method tests the getter of the id.
     */
    @Test
    public void getIdTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");

        // Assertion
        assertEquals(coordinates.getId(), null);
    }



    /**
     * This method tests the getter of the latitude.
     */
    @Test
    public void getLatitudeTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");

        // Assertion
        assertEquals(coordinates.getLatitude(), "100");
    }



    /**
     * This method tests the setter of the latitude.
     */
    @Test
    public void setLatitudeTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");

        // Test
        assertThrows(NullPointerException.class, () -> {
            coordinates.setLatitude(null);
        });

        coordinates.setLatitude("0");

        // Assertion
        assertEquals(coordinates.getLatitude(), "0");
    }



    /**
     * This method tests the getter of the longitude.
     */
    @Test
    public void getLongitudeTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");

        // Assertion 
        assertEquals(coordinates.getLongitude(), "120");
    }



    /**
     * This method tests the setter of the longitude.
     */
    @Test
    public void setLongitudeTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");

        // Test
        assertThrows(NullPointerException.class, () -> {
            coordinates.setLongitude(null);
        });

        coordinates.setLongitude("0");

        // Assertion
        assertEquals(coordinates.getLongitude(), "0");
    }




    /**
     * This method tests the getter of the courts.
     */
    /*@Test
    public void getCourtsTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");

        // Test
        Set<Court> courts = coordinates.getCourt();
        assertThrows(UnsupportedOperationException.class, () -> {
            courts.clear();
        });

        // Assertion
        assertEquals(coordinates.getCourt(), courts);
    }*/
}
