package org.group_1.terrain_petanque.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

/**
 * This class represents 
 */
@Embeddable
public class ReservationKey implements Serializable {
    
    /**
     * This attribute represents the reservation's foreign key (link to 'utilisateur' table).
     */
    @Column(name = "utilisateur_id")
    @Getter private Long utilisateurId;



    /**
     * This attribute represents the reservation's foreign key (link to 'terrain' table).
     */
    @Column(name = "terrain_id")
    @Getter private Long terrainId;
    
}
