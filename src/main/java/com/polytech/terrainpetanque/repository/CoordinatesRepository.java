package com.polytech.terrainpetanque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.polytech.terrainpetanque.entity.Coordinates;
import com.polytech.terrainpetanque.entity.Court;

/**
 * This interface represents the repository for the 'coordonnées' table.
 */
@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {

    /**
     * This method returns a list of coordinates with a specific latitude.
     *
     * @param latitude The latitude.
     * @return Return a list of coordinates with the specified latitude.
     */
    List<Coordinates> findByLatitude(String latitude);



    /**
     * This method returns a list of coordinates with a specific longitude.
     *
     * @param longitude The longitude.
     * @return Return a list of coordinates with the specified longitude.
     */
    List<Coordinates> findByLongitude(String longitude);



    /**
     * This method returns coordinates with a specific court.
     *
     * @param court The court.
     * @return Return coordinates with the specified court.
     */
    Optional<Coordinates> findByCourt(Court court);

}
