package org.group_1.terrain_petanque.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class represents the 'utilisateur' table in the database.
 */
@Entity
@Table(name = "utilisateur")
public class User {

    /**
     * This attribute represents the user's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter private Integer id;



    /**
     * This attribute represents the user's name.
     */
    @Column(name = "nom", nullable = false, length = 100)
    @Getter @Setter @NonNull private String name;



    /**
     * This attribute represents the user's surname.
     */
    @Column(name = "prenom", nullable = false, length = 100)
    @Getter @Setter @NonNull private String surname;



    /**
     * This attribute represents the user's mail.
     */
    @Column(name = "mail", nullable = false, length = 100)
    @Getter @Setter @NonNull private String mail;



    /**
     * This attribute represents the user's password.
     */
    @Column(name = "password", nullable = false, length = 100)
    @Getter @Setter @NonNull private String password;



    /**
     * This attribute represents the user's username.
     */
    @Column(name = "username", nullable = false, length = 100)
    @Getter @Setter @NonNull private String username;



    /**
     * This attribute represents a link (Many-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;
    
}
