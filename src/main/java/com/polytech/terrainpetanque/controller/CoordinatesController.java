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

import com.polytech.terrainpetanque.dto.input.CoordinatesInputDTO;
import com.polytech.terrainpetanque.dto.output.CoordinatesOutputDTO;
import com.polytech.terrainpetanque.service.CoordinatesService;

/**
 * This class represents the controller for coordinates.
 */
@RestController
@RequestMapping("/api/v1/coordinates")
public class CoordinatesController {

    /**
     * This attribute represents the service.
     */
    private final CoordinatesService coordinatesService;



    /**
     * The constructor.
     *
     * @param coordinatesService the coordinates' service.
     */
    @Autowired
    public CoordinatesController(CoordinatesService coordinatesService) {
        this.coordinatesService = coordinatesService;
    }


    /**
     * This method returns the list of coordinates.
     *
     * @return Return the list of coordinates.
     */
    @GetMapping
    public ResponseEntity<List<CoordinatesOutputDTO>> getAllCoordinates() {
        return ResponseEntity.ok(coordinatesService.getAllCoordinates());
    }



    /**
     * This method returns specific coordinates.
     * @param id The coordinates' id.
     * @return Return the specific coordinates.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CoordinatesOutputDTO> getCoordinates(@PathVariable int id) {
        try {
            return ResponseEntity.ok(coordinatesService.getCoordinates(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method creates coordinates.
     * @param coordinates The coordinates' informations.
     * @return Return the created coordinates.
     */
    @PostMapping
    public ResponseEntity<CoordinatesOutputDTO> createCoordinates(@RequestBody CoordinatesInputDTO coordinates) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coordinatesService.addCoordinates(coordinates));
    }



    /**
     * This method fully updates coordinates.
     * @param id The coordinates' id.
     * @param coordinates The coordinates' informations.
     * @return Return the updated coordinates.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CoordinatesOutputDTO> fullUpdateCoordinates(@PathVariable int id, @RequestBody CoordinatesInputDTO coordinates) {
        try {
            return ResponseEntity.ok(coordinatesService.fullUpdateCoordinates(id, coordinates));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method partially updates coordinates.
     * @param id The coordinates' id.
     * @param coordinates The coordinates' informations.
     * @return Return the updated coordinates.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CoordinatesOutputDTO> partialUpdateCoordinates(@PathVariable int id, @RequestBody CoordinatesInputDTO coordinates) {
        try {
            return ResponseEntity.ok(coordinatesService.partialUpdateCoordinates(id, coordinates));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }



    /**
     * This method deletes coordinates.
     *
     * @param id The coordinates' id.
     * @return Return no content as the deleted coordinates.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinates(@PathVariable int id) {
        coordinatesService.deleteCoordinates(id);
        return ResponseEntity.noContent().build();
    }
}
