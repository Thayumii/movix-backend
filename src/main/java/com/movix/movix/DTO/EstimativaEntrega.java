package com.movix.movix.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstimativaEntrega {
    private double distanciaMetros;
    private double tempoMinutos;
}
