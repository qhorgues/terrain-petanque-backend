package com.polytech.terrainpetanque.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.polytech.terrainpetanque.dto.input.ReservationInputDTO;
import com.polytech.terrainpetanque.dto.output.ReservationOutputDTO;
import com.polytech.terrainpetanque.service.ReservationService;

import lombok.RequiredArgsConstructor;

/**
 * This class represents the controller for the reservations.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    /**
     * This attribute represents the service for the reservations.
     */
    private final ReservationService reservationService;



    /**
     * This method creates a reservation.
     *
     * @param userId The user's id for the reservation.
     * @param courtId The court's id for the reservation.
     * @param reservation The reservation's informations.
     * @return Return the created reservation. Return not found if the user or court don't exist.
     */
    @PostMapping("/user/{userId}/court/{courtId}")
    public ResponseEntity<ReservationOutputDTO> createReservation(@PathVariable int userId, @PathVariable int courtId, @RequestBody ReservationInputDTO reservation) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(userId, courtId, reservation));
        }
        catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method gets all the reservations.
     *
     * @return Return all the reservations.
     */
    @GetMapping
    public ResponseEntity<List<ReservationOutputDTO>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }



    /**
     * This method gets a specific reservation.
     *
     * @param userId The user's id for the reservation.
     * @param courtId The court's id for the reservation.
     * @return Return the specific reservation. Return not found if the reservation doesn't exist.
     */
    @GetMapping("/user/{userId}/court/{courtId}")
    public ResponseEntity<ReservationOutputDTO> getReservation(@PathVariable int userId, @PathVariable int courtId) {
        try {
            return ResponseEntity.ok(reservationService.getReservation(userId, courtId));
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates a reservation.
     *
     * @param userId The user's id.
     * @param courtId The court's id.
     * @param reservation The reservation's informations.
     * @return Return the updates reservation. Return not found if the reservation doesn't exist.
     */
    @PatchMapping("/user/{userId}/court/{courtId}")
    public ResponseEntity<ReservationOutputDTO> partialUpdateReservation(@PathVariable int userId, @PathVariable int courtId, @RequestBody ReservationInputDTO reservation) {
        try {
            return ResponseEntity.ok(reservationService.partialUpdateReservation(userId, courtId, reservation));
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method fully updates a reservation.
     *
     * @param userId The user's id.
     * @param courtId The court's id.
     * @param reservation The reservation's informations.
     * @return Return the updates reservation. Return not found if the reservation doesn't exist.
     */
    @PutMapping("/user/{userId}/court/{courtId}")
    public ResponseEntity<ReservationOutputDTO> fullUpdateReservation(@PathVariable int userId, @PathVariable int courtId, @RequestBody ReservationInputDTO reservation) {
        try {
            return ResponseEntity.ok(reservationService.fullUpdateReservation(userId, courtId, reservation));
        } catch (NotFoundException exception) {
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
    @DeleteMapping("/user/{userId}/court/{courtId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int userId, @PathVariable int courtId) {
        reservationService.deleteReservation(userId, courtId);
        return ResponseEntity.noContent().build();
    }
}
