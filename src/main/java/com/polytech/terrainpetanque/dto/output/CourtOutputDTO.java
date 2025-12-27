package com.polytech.terrainpetanque.dto.output;

/**
 * This record represents a Data Transfer Object (DTO) for a court.
 * Output entries.
 */
public record CourtOutputDTO(
    /**
     * This field is the court's id.
     */
    int id,

    /**
     * This field is the court's name.
     */
    String name,

    /**
     * This field is the court's quantity.
     */
    int quantity,

    /**
     * This field is the court's description.
     */
    String description,

    /**
     * This field is where the court is.
     */
    CoordinatesOutputDTO coordinates
) {}
