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
 * This class represents the 'coordonnees' table in the database.
 */
@Entity
@Table(name = "coordonnees")
public class Coordinates {

    /**
     * This attribute represents the coordinates' id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter private Integer id;



    /**
     * This attribute represents the coordinates' latitude.
     */
    @Column(name = "latitude", nullable = false, length = 100)
    @Getter @Setter @NonNull private String latitude;



    /**
     * This attribute represents the coordinates' longitude.
     */
    @Column(name = "longitude", nullable = false, length = 100)
    @Getter @Setter @NonNull private String longitude;



    /**
     * This attribute represents a link (One-To-Many) with the 'terrain' table. 
     * And 'terrain' table has the foreing key.
     */
    @OneToMany(mappedBy = "coordinates")
    private Set<Court> courts;



    /**
     * The default constructor for JPA.
     */
    protected Coordinates() {}



    /**
     * The constructor for developers.
     * 
     * @param latitude The coordinates' latitude.
     * @param longitude The coordinates' longitude.
     */
    public Coordinates(@NonNull String latitude, @NonNull String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
