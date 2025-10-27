package org.group_1.terrain_petanque.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class represents the 'utilisateur' table in the database.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "utilisateur")
public class User {

    /**
     * This attribute represents the user's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE) private Integer id;



    /**
     * This attribute represents the user's name.
     */
    @Column(name = "nom", nullable = false, length = 100)
    @NonNull private String name;



    /**
     * This attribute represents the user's surname.
     */
    @Column(name = "prenom", nullable = false, length = 100)
    @NonNull private String surname;



    /**
     * This attribute represents the user's mail.
     */
    @Column(name = "mail", nullable = false, length = 100)
    @NonNull private String mail;



    /**
     * This attribute represents the user's password.
     */
    @Column(name = "password", nullable = false, length = 100)
    @NonNull private String password;



    /**
     * This attribute represents the user's username.
     */
    @Column(name = "username", nullable = false, length = 100)
    @NonNull private String username;



    /**
     * This attribute represents a link (Many-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "user")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private Set<Reservation> reservations = new HashSet<>();



    /**
     * The constructor for developers.
     * 
     * @param name The user's name.
     * @param surname The user's surname.
     * @param mail The user's mail.
     * @param password The user's password.
     * @param username The user's username.
     */
    public User(@NonNull String name, @NonNull String surname, @NonNull String mail, @NonNull String password, @NonNull String username) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.username = username;
    }
    
}
