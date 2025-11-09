package com.movix.movix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movix.movix.entity.Entrega;
import com.movix.movix.repository.EntregaRepository;

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

    public Entrega atualizar(Long id, Entrega entregaAtualizada) {
        return entregaRepository.findById(id).map(entrega -> {
            entrega.setStatus(entregaAtualizada.getStatus());
            return entregaRepository.save(entrega);
        }).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
        
    }
    public void deletar(Long id) {
    entregaRepository.deleteById(id);
    }

}
