package com.movix.movix.DTO;

import lombok.Data;

@Data
public class AtualizarLocalizacaoRequest {
    private Long entregaId;
    private double latitude;
    private double longitude;
}
