package com.polytech.terrainpetanque.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a Data Transfer Object (DTO) for a court.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourtOutputDTO {

    /**
     * This attribute represents the court's id.
     */
    @Getter @Setter private Integer id;



    /**
     * This attribute represents the court's name.
     */
    @Getter @Setter private String name;



    /**
     * This attribute represents the court's quantity.
     */
    @Getter @Setter private int quantity;



    /**
     * This attribute represents the court's description.
     */
    @Getter @Setter private String description;



    /**
     * This attribute represents the court's coordinates.
     */
    @Getter @Setter private Integer coordinatesId;

}
