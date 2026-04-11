package com.movix.movix.controller;

import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.Location;
import com.movix.movix.repository.LocationRepository;
import com.movix.movix.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/entregas")
@CrossOrigin(origins = "http://localhost:5173")
public class LocationController {

    private final LocationRepository repository;
    private final EntregaService entregaService;

    public LocationController(LocationRepository repository, EntregaService entregaService) {
        this.repository = repository;
        this.entregaService = entregaService;
    }

    // motorista envia localização.
    @PostMapping("/{id}/localizacao")
    public ResponseEntity<?> updateLocation(@PathVariable Long id, @RequestBody Location request) {
        Entrega entrega = entregaService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Entrega não encontrada."));

        Location location = new Location();
        location.setLatitude(request.getLatitude());

        location.setLongitude(request.getLongitude());

        location.setTimestamp(LocalDateTime.now());
        location.setEntrega(entrega);

        repository.save(location);
        return ResponseEntity.ok("Localização salva!");
    }

    // cliente consulta.
    @GetMapping("/{id}/localizacao")
    public ResponseEntity<?> getLocation(@PathVariable Long id) {
        Location location = repository.findTopByIdOrderByTimestampDesc(id);

        if (location == null) {
            return ResponseEntity.status(404).body("Nenhuma localização encontrada");
        }
        return ResponseEntity.ok(location);
    }
}
