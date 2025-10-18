package org.group_1.terrain_petanque.repository;

import java.util.List;
import java.util.Optional;

import org.group_1.terrain_petanque.entity.Reservation;
import org.group_1.terrain_petanque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for the 'utilisateur' table.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    /**
     * This method returns a list of users with a specific name.
     * 
     * @param name The name.
     * @return Return a list of users with the specified name.
     */
    List<User> findByName(String name);



    /**
     * This method returns a list of users with a specific surname.
     * 
     * @param surname The surname.
     * @return Return a list of users with the specified surname.
     */
    List<User> findBySurname(String surname);



    /**
     * This method returns a list of users with a specific name and surname.
     * 
     * @param name The name.
     * @param surname The surname.
     * @return Return a list of users with the specified name and surname.
     */
    List<User> findByNameAndSurname(String name, String surname);



    /**
     * This method returns a list of users with a specific mail.
     * 
     * @param mail The mail.
     * @return Return a list of users with the specified mail.
     */
    List<User> findByMail(String mail);



    /**
     * This method returns a list of users with a specific password.
     * 
     * @param password The password.
     * @return Return a list of users with the specified password.
     */
    List<User> findByPassword(String password);



    /**
     * This method returns a list of users with a specific username.
     * 
     * @param username The username.
     * @return Return a list of users with the specified username.
     */
    List<User> findByUsername(String username);



    /**
     * This method returns a list of users with a specific reservation.
     * 
     * @param reservation The reservation.
     * @return Return a list of users with the specified reservation.
     */
    Optional<User> findByReservationsContains(Reservation reservation);

}
