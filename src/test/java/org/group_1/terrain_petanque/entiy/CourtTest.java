package org.group_1.terrain_petanque.entiy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Court entity.
 */
public class CourtTest {

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        try {
            new Court("name", 0, null);
            throw new RuntimeException("It cannot be possible to have a coordinate with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        try {
            Coordinates coordinates = new Coordinates("100", "100");
            new Court(null, 0, coordinates);
            throw new RuntimeException("It cannot be possible to have a name with null");
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
        Court court = new Court("Court 1", 1, coordinates);

        // Assertion
        assertEquals(court.getId(), null);
    }



    /**
     * This method tests the getter of the name.
     */
    @Test
    public void getLatitudeTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Assertion
        assertEquals(court.getName(), "Court 1");
    }



    /**
     * This method tests the setter of the name.
     */
    @Test
    public void setLatitudeTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Test
        try {
            court.setName(null);
            throw new RuntimeException("It cannot be possible to have a name with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        court.setName("Hello");

        // Assertion
        assertEquals(court.getName(), "Hello");
    }



    /**
     * This method tests the getter of the coordinates.
     */
    @Test
    public void getCoodinatesTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Assertion
        assertEquals(court.getCoordinates(), coordinates);
    }



    /**
     * This method tests the setter of the coordinates.
     */
    @Test
    public void setCoordinatesTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Test
        try {
            court.setCoordinates(null);
            throw new RuntimeException("It cannot be possible to have a coordinates with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        Coordinates coordinates2 = new Coordinates("0", "0");
        court.setCoordinates(coordinates2);

        // Assertion
        assertEquals(court.getCoordinates(), coordinates2);
    }



    /**
     * This method tests the getter of the quantity.
     */
    @Test
    public void getQuantityTest() {
        // Init & test
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Assertion
        assertEquals(court.getQuantity(), 1);
    }



    /**
     * This method tests the getter of the quantity.
     */
    @Test
    public void setQuantityTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Test
        court.setQuantity(100);

        // Assertion
        assertEquals(court.getQuantity(), 100);
    }
    
}
