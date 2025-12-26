package com.polytech.terrainpetanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Court entity.
 */
public class CourtTest {

    /**
     * This method tests the obtainCoordinates method.
     */
    @Test
    public void obtainCourtTest() {
        // Init & test
        Court test = Court.obtainCourt(100);

        // Assertion
        assertEquals(test.getId(), 100);
    }



    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        assertThrows(NullPointerException.class, () -> {
            new Court("name", 0, null);
        });

        assertThrows(NullPointerException.class, () -> {
            Coordinates coordinates = new Coordinates("100", "100");
            new Court(null, 0, coordinates);
        });
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
    public void getNameTest() {
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
    public void setNameTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "120");
        Court court = new Court("Court 1", 1, coordinates);

        // Test
        assertThrows(NullPointerException.class, () -> {
            court.setName(null);
        });

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
        assertThrows(NullPointerException.class, () -> {
            court.setCoordinates(null);
        });

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
