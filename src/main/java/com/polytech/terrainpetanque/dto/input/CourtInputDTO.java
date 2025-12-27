package com.polytech.terrainpetanque.dto.input;

/**
 * This record represents a Data Transferable Object (DTO) for Court.
 * Input entries.
 */
public record CourtInputDTO(
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
    CoordinatesInputDTO coordinates
) {}
