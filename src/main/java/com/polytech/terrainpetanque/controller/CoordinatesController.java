package org.group_1.terrain_petanque.controller;

import java.util.List;
import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<CoordinatesDTO>> getAllCoordinates() {
        return ResponseEntity.ok(coordinatesService.getAllCoordinates());
    }



    /**
     * This method returns specific coordinates.
     * @param id The coordinates' id.
     * @return Return the specific coordinates.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CoordinatesDTO> getCoordinates(@PathVariable int id) {
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
    public ResponseEntity<CoordinatesDTO> createCoordinates(
        @RequestBody CoordinatesDTO coordinates
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coordinatesService.addCoordinates(coordinates));
    }



    /**
     * This method fully updates coordinates.
     * @param id The coordinates' id.
     * @param coordinates The coordinates' informations.
     * @return Return the updated coordinates.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CoordinatesDTO> fullUpdateCoordinates(@PathVariable int id, @RequestBody CoordinatesDTO coordinates) {
        try {
            return ResponseEntity.ok(
                coordinatesService.fullUpdateCoordinates(id, coordinates)
            );
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
    public ResponseEntity<CoordinatesDTO> partialUpdateCoordinates(@PathVariable int id, @RequestBody CoordinatesDTO coordinates) {
        try {
            return ResponseEntity.ok(
                coordinatesService.partialUpdateCoordinates(id, coordinates)
            );
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
