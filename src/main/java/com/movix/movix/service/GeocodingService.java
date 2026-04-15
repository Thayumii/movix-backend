package com.movix.movix.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class GeocodingService {
    private final RestTemplate restTemplate = new RestTemplate();

    public double[] buscarCoordenadas(String endereco) {
        try {
            String enderecoEncoded = URLEncoder.encode(
                    endereco,
                    StandardCharsets.UTF_8
            );
            String url = "https://nominatim.openstreetmap.org/search?q=" + enderecoEncoded + "&format=json&limit=1";

            List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);

            if (response == null || response.isEmpty()) {
                throw new RuntimeException("Endereço não encontrado.");
            }
            Map<String, Object> resultado = response.get(0);

            double latitude = Double.parseDouble((String) resultado.get("lat"));
            double longitude = Double.parseDouble((String) resultado.get("lon"));

            return new double[]{latitude, longitude};
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar coordenadas: " + e.getMessage());
        }
    }
}
