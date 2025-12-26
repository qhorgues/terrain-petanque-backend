package com.polytech.terrainpetanque.controller;

import java.util.List;

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

import com.polytech.terrainpetanque.dto.input.CourtInputDTO;
import com.polytech.terrainpetanque.dto.output.CourtOutputDTO;
import com.polytech.terrainpetanque.service.CourtService;

/**
 * This class represents the controller for a court.
 */
@RestController
@RequestMapping("/api/v1/courts")
public class CourtController {

    /**
     * This attribute represents the service.
     */
    private final CourtService courtService;



    /**
     * The constructor.
     *
     * @param coordinatesService the court's service.
     */
    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }



    /**
     * This method returns all courts.
     *
     * @return Return all courts.
     */
    @GetMapping
    public ResponseEntity<List<CourtOutputDTO>> getAllCourt() {
        return ResponseEntity.ok(courtService.getAllCourts());
    }



    /**
     * This method returns a specific court.
     *
     * @param id The court's id.
     * @return Return the specific court.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CourtOutputDTO> getCourt(@PathVariable int id) {
        try {
            return ResponseEntity.ok(courtService.getCourt(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method creates a court.
     *
     * @param court The court's informations.
     * @return Return the created court.
     */
    @PostMapping
    public ResponseEntity<CourtOutputDTO> createCourt(@RequestBody CourtInputDTO court) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courtService.addCourt(court));
    }



    /**
     * This method fully updates a court.
     *
     * @param id The court's id.
     * @param court The court's informations.
     * @return Return the updated court.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CourtOutputDTO> fullUpdateCourt(@PathVariable int id, @RequestBody CourtInputDTO court) {
        try {
            return ResponseEntity.ok(courtService.fullUpdateCourt(id, court));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates a court.
     *
     * @param id The court's id.
     * @param court The court's informations.
     * @return Return the updated court.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CourtOutputDTO> partialUpdateCourt(@PathVariable int id, @RequestBody CourtInputDTO court) {
        try {
            return ResponseEntity.ok(courtService.partialUpdateCourt(id, court));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method deletes a court.
     *
     * @param id The court's id.
     * @return Return no content as the deleted court.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourt(@PathVariable int id) {
        courtService.deleteCourt(id);
        return ResponseEntity.noContent().build();
    }

}
