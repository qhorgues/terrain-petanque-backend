package org.group_1.terrain_petanque.repository;

import java.util.List;

import org.group_1.terrain_petanque.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.micrometer.common.lang.NonNull;

/**
 * This interface represents the repository for coordinates.
 */
@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {

    /**
     * This method return a list of coordinates with a specific latitude.
     * 
     * @param latitude The latitude.
     * @return Return a list of coordinates with the specified latitude.
     */
    List<Coordinates> findByLatitude(@NonNull String latitude);



    /**
     * This method return a list of coordinates with a specific longitude.
     * 
     * @param longitude The longitude.
     * @return Return a list of coordinates with the specified longitude.
     */
    List<Coordinates> findByLongitude(@NonNull String longitude);

}
