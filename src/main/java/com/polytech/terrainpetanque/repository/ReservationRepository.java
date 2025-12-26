package com.polytech.terrainpetanque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytech.terrainpetanque.entity.Court;
import com.polytech.terrainpetanque.entity.Reservation;
import com.polytech.terrainpetanque.entity.ReservationKey;
import com.polytech.terrainpetanque.entity.User;

/**
 * This interface represents the repository for 'reservation' association table.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationKey> {

    /**
     * This method returns a list of reservation with a specific user.
     *
     * @param user The user.
     * @return Return a list of reservation with the specified user.
     */
    List<Reservation> findByUser(User user);



    /**
     * This method returns a list of reservation with a specific court.
     *
     * @param court The court.
     * @return Return a list of reservation with the specified court.
     */
    List<Reservation> findByCourt(Court court);



    /**
     * This method returns a list of reservation with a specific 'reservation'.
     *
     * @param reservation The 'reservation'.
     * @return Return a list of reservation with the specified 'reservation'.
     */
    List<Reservation> findByReservation(int reservation);

}
