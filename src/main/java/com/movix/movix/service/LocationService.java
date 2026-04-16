package com.movix.movix.service;

import com.movix.movix.DTO.AtualizarLocalizacaoRequest;
import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.Location;
import com.movix.movix.entity.StatusEntrega;
import com.movix.movix.repository.EntregaRepository;
import com.movix.movix.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocationService {

    private final LocationRepository repository;
    private final EntregaRepository entregaRepository;

    public LocationService(LocationRepository repository, EntregaRepository entregaRepository) {
        this.repository = repository;
        this.entregaRepository = entregaRepository;
    }

    public Location salvarLocalizacao(
            Long entregaId,
            AtualizarLocalizacaoRequest request
    ) {
        Entrega entrega = entregaRepository.findById(entregaId).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        if (entrega.getStatus() == StatusEntrega.EM_TRANSPORTE) {
            entrega.setStatus(StatusEntrega.SAIU_PARA_ENTREGA);
            entregaRepository.save(entrega);
        }
        Location location = repository.findTopByIdOrderByTimestampDesc(entregaId);
        if (location == null) {
            location = new Location();
            location.setEntrega(entrega);
        }

        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());
        location.setTimestamp((LocalDateTime.now()));

        return repository.save(location);
    }

    public Location buscarUltimaPorEntrega(Long entregaId) {
        return repository.findTopByIdOrderByTimestampDesc(entregaId);
    }
}
