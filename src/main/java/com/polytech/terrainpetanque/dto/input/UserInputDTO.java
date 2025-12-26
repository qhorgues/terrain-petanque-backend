package com.polytech.terrainpetanque.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a Data Transfer Object (DTO) for a user.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInputDTO {

    /**
     * This attribute represents the user's id.
     */
    @Getter @Setter private Integer id;



    /**
     * This attribute represents the user's name.
     */
    @Getter @Setter private String name;



    /**
     * This attribute represents the user's surname.
     */
    @Getter @Setter private String surname;



    /**
     * This attribute represents the user's mail.
     */
    @Getter @Setter private String mail;



    /**
     * This attribute represents the user's password.
     */
    @Getter @Setter private String password;



    /**
     * This attribute represents the user's username.
     */
    @Getter @Setter private String username;

}
