package com.polytech.terrainpetanque.dto.output;

/**
 * This record represents a Data Transfer Object (DTO) for coordinates.
 * Output entries.
 */
public record CoordinatesOutputDTO(
    /**
     * This field is the coordinates' id.
     */
    int id,

    /**
     * This field is the coordinates' latitude.
     */
    double latitude,

    /**
     * This field is the coordinates' longitude.
     */
    double longitude
) {}
