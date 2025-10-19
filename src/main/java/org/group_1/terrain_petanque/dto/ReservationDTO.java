package org.group_1.terrain_petanque.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a Data Transfer Object (DTO) for a reservation.
 */
public class ReservationDTO {

    /**
     * This attribute represents the user's id.
     */
    @Getter @Setter private Integer userId;



    /**
     * This attribute represents the court's id.
     */
    @Getter @Setter private Integer courtId;



    /**
     * This attribute represents the 'reservation'.
     */
    @Getter @Setter private int reservation;

}
