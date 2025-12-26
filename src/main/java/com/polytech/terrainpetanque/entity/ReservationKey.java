package org.group_1.terrain_petanque.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ReservationKey implements Serializable {
    
    /**
     * This attribute represents the reservation's foreign key (link to 'utilisateur' table).
     */
    @Column(name = "utilisateur_id")
    @Setter(AccessLevel.NONE) private Integer userId;



    /**
     * This attribute represents the reservation's foreign key (link to 'terrain' table).
     */
    @Column(name = "terrain_id")
    @Setter(AccessLevel.NONE) private Integer courtId;
    
}
