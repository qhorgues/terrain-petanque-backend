package com.polytech.terrainpetanque.dto.output;

/**
 * This class represents a Data Transfer Object (DTO) for coordinates.
 */
public record CoordinatesOutputDTO(
    /**
     * This field is the coordinates' id.
     */
    int id,

    /**
     * This field is the coordinates' latitude.
     */
    String latitude,

    /**
     * This field is the coordinates' longitude.
     */
    String longitude,

    /**
     * This is the court's id for coordinates.
     */
    int courtId
) {}
