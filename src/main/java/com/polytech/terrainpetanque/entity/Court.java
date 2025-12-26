package org.group_1.terrain_petanque.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class represents the 'terrain' table in the database.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "terrain")
public class Court {

    /**
     * This method generate an entity with a specifi ID.
     * But the object is not in a logical state, so don't use it to handle a database.
     * 
     * @param id The entity's id.
     * @return Return the entity.
     */
    public static Court obtainCourt(int id) {
        Court result = new Court();
        result.id = id;
        return result;
    }



    /**
     * This attribute represents the court's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE) private Integer id;



    /**
     * This attribute represents the court's name.
     */
    @Column(name = "nom", nullable = false, length = 100)
    @NonNull private String name;



    /**
     * This attribute represents the court's quantity.
     */
    @Column(name = "quantite")
    private int quantity;



    /**
     * This attribute represents the court's description.
     */
    @Column(name = "description", length = 200)
    private String description;



    /**
     * This attribute represents the court's foreign key (link to 'coordonees' table).
     */
    @OneToOne
    @JoinColumn(name= "coordonnees_id", nullable = false)
    @NonNull private Coordinates coordinates;



    /**
     * This attribute represents a link (Many-To-Many) with the 'reservation' association table.
     */
    @OneToMany(mappedBy = "court")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private Set<Reservation> reservations = new HashSet<>();



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
