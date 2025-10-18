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
public class Court {

    /**
     * This attribute represents the court's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter private Integer id;



    /**
     * This attribute represents the court's name.
     */
    @Column(name = "nom", nullable = false, length = 100)
    @Getter @Setter @NonNull private String name;



    /**
     * This attribute represents the court's quantity.
     */
    @Column(name = "quantite")
    @Getter @Setter private int quantity;



    /**
     * This attribute represents the court's description.
     */
    @Column(name = "description", length = 200)
    @Getter @Setter private String description;



    /**
     * This attribute represents the court's foreign key (link to 'coordonees' table).
     */
    @ManyToOne
    @JoinColumn(name= "coordonnees_id", nullable = false)
    @Getter @Setter @NonNull private Coordinates coordinates;



    /**
     * This attribute represents a link (Many-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "court")
    private Set<Reservation> reservations;



    /**
     * The default constructor for JPA.
     */
    protected Court() {}



    /**
     * The constructor for developers.
     * 
     * @param name The court's name.
     * @param quantity The court's quantity.
     * @param coordinates The court's coordinates.
     */
    public Court(@NonNull String name, int quantity, @NonNull Coordinates coordinates) {
        this.name = name;
        this.quantity = quantity;
        this.coordinates = coordinates;
    }

}
