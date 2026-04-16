package com.movix.movix.controller;

import com.movix.movix.DTO.AtualizarLocalizacaoRequest;
import com.movix.movix.entity.Location;
import com.movix.movix.service.EntregaService;
import com.movix.movix.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
@CrossOrigin(origins = "http://localhost:5173")
public class LocationController {

    private final EntregaService entregaService;
    private final LocationService locationService;

    public LocationController(EntregaService entregaService, LocationService locationService) {
        this.entregaService = entregaService;
        this.locationService = locationService;
    }

    // motorista envia localização.
    @PostMapping("/{id}/localizacao")
    public ResponseEntity<?> updateLocation(@PathVariable Long id, @RequestBody AtualizarLocalizacaoRequest request) {
        locationService.salvarLocalizacao(id, request);

        return ResponseEntity.ok("Localização salva!");
    }

    // cliente consulta.
    @GetMapping("/{id}/localizacao")
    public ResponseEntity<?> getLocation(@PathVariable Long id) {
        Location location = locationService.buscarUltimaPorEntrega(id);

        if (location == null) {
            return ResponseEntity.status(404).body("Nenhuma localização encontrada");
        }
        return ResponseEntity.ok(location);
    }
}
