package org.group_1.terrain_petanque.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the 'reservation' table in the database.
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    /**
     * This attribute represents the reservation's keys.
     */
    @EmbeddedId
    private ReservationKey id;



    /**
     * This attribute represents the user's id.
     */
    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id")
    @Getter private Utilisateur utilisateur;



    /**
     * This attribute represents the court's id.
     */
    @ManyToOne
    @MapsId("terrainId")
    @JoinColumn(name = "terrain_id")
    @Getter private Terrain terrain;



    /**
     * This attribute represents the reservation.
     */
    @Getter @Setter private int reservation;

}
