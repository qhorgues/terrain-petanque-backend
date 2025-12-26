package com.polytech.terrainpetanque.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * This class tests the Court entity.
 */
public class ReservationTest {

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        User user = new User("a", "b", "c", "d", "e");
        Court court = new Court("court 1", 1, new Coordinates("100", "120"));

        assertThrows(NullPointerException.class, () -> {
            new Reservation(user, null, 0);
        });

        assertThrows(NullPointerException.class, () -> {
            new Reservation(null, court, 0);
        });
    }



    /**
     * This method tests the getter the user.
     */
    @Test
    public void getUserTest() {
        // Init & test
        User user = new User("a", "b", "c", "d", "e");
        Court court = new Court("court 1", 1, new Coordinates("100", "120"));
        Reservation reservation = new Reservation(user, court, 0);

        // Assertion
        assertEquals(reservation.getUser(), user);
    }



    /**
     * This method tests the getter the court.
     */
    @Test
    public void getCourtTest() {
        // Init & test
        User user = new User("a", "b", "c", "d", "e");
        Court court = new Court("court 1", 1, new Coordinates("100", "120"));
        Reservation reservation = new Reservation(user, court, 0);

        // Assertion
        assertEquals(reservation.getCourt(), court);
    }



    /**
     * This method tests the getter the reservation.
     */
    @Test
    public void getReservationTest() {
        // Init & test
        User user = new User("a", "b", "c", "d", "e");
        Court court = new Court("court 1", 1, new Coordinates("100", "120"));
        Reservation reservation = new Reservation(user, court, 1000);

        // Assertion
        assertEquals(reservation.getReservation(), 1000);
    }



    /**
     * This method tests the setter the reservation.
     */
    @Test
    public void setReservationTest() {
        // Init
        User user = new User("a", "b", "c", "d", "e");
        Court court = new Court("court 1", 1, new Coordinates("100", "120"));
        Reservation reservation = new Reservation(user, court, 1000);

        // Test
        reservation.setReservation(10);

        // Assertion
        assertEquals(reservation.getReservation(), 10);
    }

}
