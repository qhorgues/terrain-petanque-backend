package org.group_1.terrain_petanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Coordinates entity.
 */
public class CoordinatesTest {

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        try {
            new Coordinates("100", null);
            throw new RuntimeException("It cannot be possible to have a longitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        try {
            new Coordinates(null, "120");
            throw new RuntimeException("It cannot be possible to have a latitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }
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
        try {
            coordinates.setLatitude(null);
            throw new RuntimeException("It cannot be possible to have a latitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

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
         try {
            coordinates.setLongitude(null);
            throw new RuntimeException("It cannot be possible to have a longitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        coordinates.setLongitude("0");

        // Assertion
        assertEquals(coordinates.getLongitude(), "0");
    }




    /**
     * This method tests the getter of the courts.
     */
    @Test
    public void getCourtsTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");

        // Test
        Set<Court> courts = coordinates.getCourts();
        try {
            courts.clear();
            throw new RuntimeException("Modification of an umutable object.");
        }
        catch (UnsupportedOperationException exception) {}

        // Assertion
        assertEquals(coordinates.getCourts(), courts);
    }
}
