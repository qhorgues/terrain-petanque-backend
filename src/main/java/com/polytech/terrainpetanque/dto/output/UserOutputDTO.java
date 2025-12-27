package com.polytech.terrainpetanque.dto.output;

/**
 * This record represents a Data Transfer Object (DTO) for a user.
 * Output entries.
 */
public record UserOutputDTO(
    /**
     * This field is the user's id.
     */
    int id,

    /**
     * This field is the user's name.
     */
    String name,

    /**
     * This field is the user's surname.
     */
    String surname,

    /**
     * This field is the user's mail.
     */
    String mail,

    /**
     * This field is the user's username.
     */
    String username
) {}
