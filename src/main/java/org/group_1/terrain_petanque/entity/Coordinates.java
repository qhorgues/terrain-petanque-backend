package org.group_1.terrain_petanque.entity;

import java.util.Collections;
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
 * This class represents the 'coordonnees' table in the database.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "coordonnees")
public class Coordinates {

    /**
     * This method generate an entity with a specifi ID.
     * But the object is not in a logical state, so don't use it to handle a database.
     * 
     * @param id The entity's id.
     * @return Return the entity.
     */
    public static Coordinates obtainCoordinates(int id) {
        Coordinates result = new Coordinates();
        result.id = id;
        return result;
    }



    /**
     * This attribute represents the coordinates' id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE) private Integer id;



    /**
     * This attribute represents the coordinates' latitude.
     */
    @Column(name = "latitude", nullable = false, length = 100)
    @NonNull private String latitude;



    /**
     * This attribute represents the coordinates' longitude.
     */
    @Column(name = "longitude", nullable = false, length = 100)
    @NonNull private String longitude;



    /**
     * This attribute represents a link (One-To-Many) with the 'terrain' table. 
     * And 'terrain' table has the foreing key.
     */
    @OneToMany(mappedBy = "coordinates")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private Set<Court> courts = new HashSet<>();



    /**
     * This method returns the courts.
     * The courts cannot be modified.
     * 
     * @return Return the courts.
     */
    public Set<Court> getCourts() {
        return Collections.unmodifiableSet(courts);
    }



    /**
     * This method add a court.
     * 
     * @param court The court to add.
     */
    public void addCourt(Court court) {
        courts.add(court);
    }



    /**
     * This method remove a court.
     * 
     * @param court The court to remove.
     */
    public void removeCourt(Court court) {
        courts.remove(court);
    }



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
