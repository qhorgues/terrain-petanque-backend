package org.group_1.terrain_petanque.controller;

import java.util.List;
import org.group_1.terrain_petanque.dto.ReservationDTO;
import org.group_1.terrain_petanque.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

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

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(
        @RequestBody ReservationDTO reservation
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            reservationService.addReservation(reservation)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(
        @PathVariable int userId,
        @PathVariable int courtId,
        @RequestBody ReservationDTO reservation
    ) {
        try {
            return ResponseEntity.ok(
                reservationService.updateReservation(
                    userId,
                    courtId,
                    reservation
                )
            );
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(
        @PathVariable int userId,
        @PathVariable int courtId
    ) {
        reservationService.deleteReservation(userId, courtId);
        return ResponseEntity.noContent().build();
    }
}
