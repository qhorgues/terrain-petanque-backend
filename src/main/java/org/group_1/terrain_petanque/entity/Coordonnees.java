package org.group_1.terrain_petanque.entity;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the 'coordonnees' table in the database.
 */
@Entity
@Table(name = "coordonnees")
public class Coordonnees {

    /**
     * This attribute represents the coordinates' id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;



    /**
     * This attribute represents the coordinates' latitude.
     */
    @Column(nullable = false)
    @Getter @Setter @NonNull private String latitude;


    /**
     * This attribute represents the coordinates' longitude.
     */
    @Column(nullable = false)
    @Getter @Setter @NonNull private String longitude;



    /**
     * This attribute represents a link (One-To-Many) with the 'terrain' table. 
     * And 'terrain' table has the foreing key.
     */
    @OneToMany(mappedBy = "coordonnees")
    private Set<Terrain> terrains;

}
