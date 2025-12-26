package com.polytech.terrainpetanque.dto.input;

/**
 * This record represents a Data Transfer Object (DTO) for coordinates.
 * Input entries.
 */
public record CoordinatesInputDTO(
    /**
     * This field is the coordinates' latitude.
     */
    String latitude,

    /**
     * This field is the coordinates' longitude.
     */
    String longitude
) {}
