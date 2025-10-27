package org.group_1.terrain_petanque.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * This class represents the 'reservation' table in the database.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    /**
     * This attribute represents the reservation's keys.
     */
    @EmbeddedId
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private ReservationKey id;



    /**
     * This attribute represents the user's id.
     */
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(nullable = false, name = "utilisateur_id")
    @Setter(AccessLevel.NONE) @NonNull private User user;



    /**
     * This attribute represents the court's id.
     */
    @ManyToOne
    @MapsId("courtId")
    @JoinColumn(nullable = false, name = "terrain_id")
    @Setter(AccessLevel.NONE) @NonNull private Court court;



    /**
     * This attribute represents the reservation.
     */
    private int reservation;



    /**
     * The constructor for developers.
     * 
     * @param user The user.
     * @param court The court.
     * @param reservation The reservation.
     */
    public Reservation(@NonNull User user, @NonNull Court court, int reservation) {
        this.user = user;
        this.court = court;
        this.reservation = reservation;
    }

}
