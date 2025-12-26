package com.polytech.terrainpetanque.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a Data Transfer Object (DTO) for coordinates.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoordinatesOutputDTO {

    /**
     * This attribute represents the coordinates' id.
     */
    private Integer id;



    /**
     * This attribute represents the coordinates' latitude.
     */
    private String latitude;



    /**
     * This attribute represents the coordinates' longitude.
     */
    private String longitude;



    /**
     * This attribute represents the coordinates' courts.
     */
    private Integer courtId;

}
