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
public class Utilisateur {

    /**
     * This attribute represents the user's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;



    /**
     * This attribute represents the user's name.
     */
    @Column(nullable = false, length = 100)
    @Getter @Setter @NonNull private String nom;



    /**
     * This attribute represents the user's surname.
     */
    @Column(nullable = false, length = 100)
    @Getter @Setter @NonNull private String prenom;



    /**
     * This attribute represents the user's mail.
     */
    @Column(nullable = false, length = 100)
    @Getter @Setter @NonNull private String mail;



    /**
     * This attribute represents the user's password.
     */
    @Column(nullable = false, length = 100)
    @Getter @Setter @NonNull private String password;



    /**
     * This attribute represents the user's username.
     */
    @Column(nullable = false, length = 100)
    @Getter @Setter @NonNull private String username;



    /**
     * This attribute represents a link (Many-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "utilisateur")
    private Set<Reservation> reservations;
    
}
