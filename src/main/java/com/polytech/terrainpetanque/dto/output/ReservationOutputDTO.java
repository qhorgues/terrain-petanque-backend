package com.polytech.terrainpetanque.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a Data Transfer Object (DTO) for a reservation.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationOutputDTO {

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
