package org.group_1.terrain_petanque.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class represents the 'terrain' table in the database.
 */
@Entity
@Table(name = "terrain")
public class Terrain {

    /**
     * This attribute represents the court's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;



    /**
     * This attribute represents the court's name.
     */
    @Column(nullable = false)
    @Getter @Setter @NonNull private String nom;



    /**
     * This attribute represents the court's quantity.
     */
    @Getter @Setter private int quantite;



    /**
     * This attribute represents the court's description.
     */
    @Getter @Setter private String description;



    /**
     * This attribute represents the court's foreign key (link to 'coordonees' table).
     */
    @ManyToOne
    @JoinColumn(name= "coordonees_id", nullable = false)
    @Getter private Coordonnees coordonnees;



    /**
     * This attribute represents a link (One-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "terrain")
    private Set<Reservation> reservations;

}
