package com.polytech.terrainpetanque.dto.input;

/**
 * This class represents a Data Transfer Object (DTO) for a user.
 */
public record UserInputDTO(
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
     * This field is the user's password.
     */
    String password,

    /**
     * This field is the user's username.
     */
    String username
) {}
