package com.movix.movix.service;

import com.movix.movix.DTO.EstimativaEntrega;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class RotaService {

    public EstimativaEntrega calcularRota(
            double origemLat,
            double origemLng,
            double destinoLat,
            double destinoLng
    ) {
        String url = String.format(
                Locale.US,
                "https://router.project-osrm.org/route/v1/driving/%f,%f;%f,%f?overview=false",
                origemLng,
                origemLat,
                destinoLng,
                destinoLat
        );
        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);

        if (response == null || !response.containsKey("routes")) {
            throw new RuntimeException("Erro ao calcular rota.");
        }

        List<Map<String, Object>> routes = (List<Map<String, Object>>) response.get("routes");

        if (routes.isEmpty()) {
            throw new RuntimeException("Nenhuma rota encontrada.");
        }

        Map<String, Object> route = routes.get(0);

        double distanciaMetros = ((Number) route.get("distance")).doubleValue();
        double duracaoMinutos = ((Number) route.get("duration")).doubleValue() / 60;

        return new EstimativaEntrega(
                distanciaMetros,
                duracaoMinutos
        );
    }
}
