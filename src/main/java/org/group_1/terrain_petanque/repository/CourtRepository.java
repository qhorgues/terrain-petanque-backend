package org.group_1.terrain_petanque.repository;

import java.util.List;
import java.util.Optional;

import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.group_1.terrain_petanque.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for the 'terrain' table.
 */
@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {
    
    /**
     * This method returns a list of courts with a specific name.
     * 
     * @param name The name.
     * @return Return a list of courts with the specified name.
     */
    List<Court> findByName(String name);



    /**
     * This method returns a list of courts with a specific quantity.
     * 
     * @param quantity The quantity.
     * @return Return a list of courts with the specified quantity.
     */
    List<Court> findByQuantity(int quantity);



    /**
     * This method returns a list of courts with a specific description.
     * 
     * @param description The description.
     * @return Return a list of courts with the specified description.
     */
    List<Court> findByDescription(String description);



    /**
     * This method returns a list of courts with a specific coordinates.
     * 
     * @param coordinates The coordinates.
     * @return Return a list of courts with the specified coordinates.
     */
    List<Court> findByCoordinates(Coordinates coordinates);



    /**
     * This method returns a list of courts with a specific reservation.
     * 
     * @param reservation The reservation.
     * @return Return a list of courts with the specified reservation.
     */
    Optional<Court> findByReservationsContains(Reservation reservation);

}
