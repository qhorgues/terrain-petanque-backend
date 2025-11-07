package org.group_1.terrain_petanque.controller;

import java.util.List;
import org.group_1.terrain_petanque.dto.CourtDTO;
import org.group_1.terrain_petanque.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/court")
public class CourtController {

    @Autowired
    private CourtService courtService;

    @GetMapping
    public ResponseEntity<List<CourtDTO>> getAllCourt() {
        return ResponseEntity.ok(courtService.getAllCourts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtDTO> getCourt(@PathVariable int id) {
        try {
            return ResponseEntity.ok(courtService.getCourt(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CourtDTO> createCourt(@RequestBody CourtDTO court) {
        return ResponseEntity.ok(courtService.addCourt(court));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourtDTO> updateCourt(
        @PathVariable int id,
        @RequestBody CourtDTO court
    ) {
        try {
            return ResponseEntity.ok(courtService.updateCourt(id, court));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourt(@PathVariable int id) {
        courtService.deleteCourt(id);
        return ResponseEntity.noContent().build();
    }
}
