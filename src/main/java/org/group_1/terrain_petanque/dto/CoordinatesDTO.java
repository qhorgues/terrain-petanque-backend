package org.group_1.terrain_petanque.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a Data Transfer Object (DTO) for coordinates.
 */
public class CoordinatesDTO {

    /**
     * This attribute represents the coordinates' id.
     */
    @Getter @Setter private Integer id;



    /**
     * This attribute represents the coordinates' latitude.
     */
    @Getter @Setter private String latitude;



    /**
     * This attribute represents the coordinates' longitude.
     */
    @Getter @Setter private String longitude;



    /**
     * This attribute represents the coordinates' courts.
     */
    @Getter @Setter private Set<Integer> courtsId;
    
}
