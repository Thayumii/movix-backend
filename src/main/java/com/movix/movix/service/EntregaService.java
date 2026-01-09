package com.movix.movix.service;

import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.StatusEntrega;
import com.movix.movix.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<Entrega> listarTodas() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> buscarPorId(Long id) {
        return entregaRepository.findById(id);
    }

    public Entrega salvar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega atualizarStatus(Long id, StatusEntrega novoStatus) {
        return entregaRepository.findById(id).map(entrega -> {
            entrega.setStatus(novoStatus);
            return entregaRepository.save(entrega);
        }).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
    }

    public Entrega atualizar(Long id, Entrega entregaAtualizada) {
        return entregaRepository.findById(id).map(entrega -> {
            entrega.setStatus(entregaAtualizada.getStatus());
            entrega.setMotorista(entregaAtualizada.getMotorista());
            entrega.setVeiculoPlaca(entregaAtualizada.getVeiculoPlaca());
            entrega.setDataPrevista(entregaAtualizada.getDataPrevista());
            return entregaRepository.save(entrega);
        }).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

    }

    public void deletar(Long id) {
        entregaRepository.deleteById(id);
    }

}
