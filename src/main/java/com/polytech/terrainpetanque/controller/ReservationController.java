package com.polytech.terrainpetanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.terrainpetanque.dto.output.ReservationOutputDTO;
import com.polytech.terrainpetanque.service.ReservationService;

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
    public ResponseEntity<List<ReservationOutputDTO>> getAllReservation() {
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
    public ResponseEntity<ReservationOutputDTO> getReservation(
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
    public ResponseEntity<ReservationOutputDTO> createReservation(
        @RequestBody ReservationOutputDTO reservation
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
    public ResponseEntity<ReservationOutputDTO> fullUpdateReservation(
        @PathVariable int userId,
        @PathVariable int courtId,
        @RequestBody ReservationOutputDTO reservation
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
    public ResponseEntity<ReservationOutputDTO> partialUpdateReservation(
        @PathVariable int userId,
        @PathVariable int courtId,
        @RequestBody ReservationOutputDTO reservation
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
