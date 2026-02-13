package com.movix.movix.DTO;

import com.movix.movix.entity.StatusEntrega;
import lombok.Data;

@Data
public class AtualizarStatusRequest {
    private StatusEntrega status;
    private String origem;
    private String destino;
}
