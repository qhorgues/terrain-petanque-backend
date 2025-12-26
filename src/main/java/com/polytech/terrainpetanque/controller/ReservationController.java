package org.group_1.terrain_petanque.controller;

import java.util.List;
import org.group_1.terrain_petanque.dto.ReservationDTO;
import org.group_1.terrain_petanque.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the controller for a reservation.
 */
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    /**
     * This attribute represents the service.
     */
    private final ReservationService reservationService;



    /**
     * The constructor.
     * 
     * @param reservationService The reservation's service.
     */
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }



    /**
     * This method returns all reservations.
     * 
     * @return Return all reservations.
     */
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }



    /**
     * This method return a specific reservation.
     * 
     * @param userId The user's id.
     * @param courtId The court's id.
     * @return Return the specific reservation.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservation(
        @PathVariable int userId,
        @PathVariable int courtId
    ) {
        try {
            return ResponseEntity.ok(
                reservationService.getReservation(userId, courtId)
            );
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method creates a reservation.
     * 
     * @param reservation The reservation's id.
     * @return Return the created reservation.
     */
    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(
        @RequestBody ReservationDTO reservation
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            reservationService.addReservation(reservation)
        );
    }



    /**
     * This method fully updates a reservation.
     * 
     * @param userId The user's id.
     * @param courtId The court's id.
     * @param reservation The reservation's informations.
     * @return Return the updates reservation.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> fullUpdateReservation(
        @PathVariable int userId,
        @PathVariable int courtId,
        @RequestBody ReservationDTO reservation
    ) {
        try {
            return ResponseEntity.ok(
                reservationService.fullUpdateReservation(
                    userId,
                    courtId,
                    reservation
                )
            );
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates a reservation.
     * 
     * @param userId The user's id.
     * @param courtId The court's id.
     * @param reservation The reservation's informations.
     * @return Return the updates reservation.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ReservationDTO> partialUpdateReservation(
        @PathVariable int userId,
        @PathVariable int courtId,
        @RequestBody ReservationDTO reservation
    ) {
        try {
            return ResponseEntity.ok(
                reservationService.partialUpdateReservation(
                    userId,
                    courtId,
                    reservation
                )
            );
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method deletes a reservation.
     * 
     * @param userId The user's id.
     * @param courtId The court's id.
     * @return Return no content as the deleted reservation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(
        @PathVariable int userId,
        @PathVariable int courtId
    ) {
        reservationService.deleteReservation(userId, courtId);
        return ResponseEntity.noContent().build();
    }
}
