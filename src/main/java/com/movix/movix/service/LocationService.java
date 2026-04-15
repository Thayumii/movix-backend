package com.movix.movix.service;

import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.Location;
import com.movix.movix.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Location salvarLocalizacao(
            Entrega entrega,
            double latitude,
            double longitude
    ) {
        Location location = new Location();
        location.setEntrega(entrega);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setTimestamp((LocalDateTime.now()));

        return repository.save(location);
    }

    public Location buscarUltimaPorEntrega(Long entregaId) {
        return repository.findTopByIdOrderByTimestampDesc(entregaId);
    }
}
