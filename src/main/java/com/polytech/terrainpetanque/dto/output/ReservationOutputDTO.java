package com.polytech.terrainpetanque.dto.output;

/**
 * This class represents a Data Transfer Object (DTO) for a reservation.
 */
public record ReservationOutputDTO(
    /**
     * This field is the user's id for a reservation.
     */
    int userId,

    /**
     * This field is the court's id for a reservation.
     */
    int courtId,

    /**
     * This field is the 'reservation'
     */
    int reservation
) {}
