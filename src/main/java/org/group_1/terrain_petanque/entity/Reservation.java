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
    @MapsId("userId")
    @JoinColumn(name = "utilisateur_id")
    @Getter private User user;



    /**
     * This attribute represents the court's id.
     */
    @ManyToOne
    @MapsId("courtId")
    @JoinColumn(name = "terrain_id")
    @Getter private Court court;



    /**
     * This attribute represents the reservation.
     */
    @Getter @Setter private int reservation;



    /**
     * The default constructor for JPA.
     */
    public Reservation() {}



    /**
     * The constructor for developers.
     * 
     * @param user The user.
     * @param court The court.
     * @param reservation The reservation.
     */
    public Reservation(User user, Court court, int reservation) {
        this.user = user;
        this.court = court;
        this.reservation = reservation;
    }

}
