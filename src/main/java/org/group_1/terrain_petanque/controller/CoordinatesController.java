package org.group_1.terrain_petanque.controller;

import java.util.List;
import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coordinates")
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    @GetMapping
    public ResponseEntity<List<CoordinatesDTO>> getAllCoordinates() {
        return ResponseEntity.ok(coordinatesService.getAllCoordinates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordinatesDTO> getCoordinates(@PathVariable int id) {
        try {
            return ResponseEntity.ok(coordinatesService.getCoordinates(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CoordinatesDTO> createCoordinates(
        @RequestBody CoordinatesDTO coordinates
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coordinatesService.addCoordinates(coordinates));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordinatesDTO> updateCoordinates(
        @PathVariable int id,
        @RequestBody CoordinatesDTO coordinates
    ) {
        try {
            return ResponseEntity.ok(
                coordinatesService.updateCoordinates(id, coordinates)
            );
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinates(@PathVariable int id) {
        coordinatesService.deleteCoordinates(id);
        return ResponseEntity.noContent().build();
    }
}
