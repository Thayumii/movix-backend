package com.movix.movix.controller;

import com.movix.movix.entity.Location;
import com.movix.movix.repository.LocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:5173")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    // motorista envia localização.
    @PostMapping("/update")
    public String updateLocation(@RequestBody Location location) {
        location.setTimestamp(LocalDateTime.now());
        repository.save(location);
        return "Localização salva!";
    }

    // cliente consulta.
    @GetMapping("/{locationId}")
    public ResponseEntity<?> getLocation(@PathVariable String locationId) {
        Location location = repository.findTopByLocationIdOrderByTimestampDesc(locationId);

        if (location == null) {
            return ResponseEntity.status(404).body("Nenhuma localização encontrada");
        }
        return ResponseEntity.ok(location);
    }
}
