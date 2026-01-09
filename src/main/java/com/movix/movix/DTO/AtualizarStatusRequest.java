package com.movix.movix.DTO;

import com.movix.movix.entity.StatusEntrega;

public class AtualizarStatusRequest {
    private StatusEntrega status;

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
