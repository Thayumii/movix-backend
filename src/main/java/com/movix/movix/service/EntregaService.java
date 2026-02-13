package com.movix.movix.service;

import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.StatusEntrega;
import com.movix.movix.repository.EntregaRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Entrega salvar(Entrega entrega) {
        entrega.adicionarMovimentacao("Entrega registrada no sistema Movix.", "Origem", "Aguardando despacho");
        return entregaRepository.save(entrega);
    }

    @Transactional
    public Entrega atualizarStatus(Long id, StatusEntrega novoStatus, String origem, String destino) {
        return entregaRepository.findById(id).map(entrega -> {
            entrega.setStatus(novoStatus);
            entrega.adicionarMovimentacao("Status alterado para " + novoStatus, origem, destino);
            return entregaRepository.save(entrega);
        }).orElseThrow(() -> new RuntimeException("Entrega não encontrada"));
    }

    @Transactional
    public Entrega atualizar(Long id, Entrega entregaAtualizada) {
        return entregaRepository.findById(id).map(entrega -> {
            if (entrega.getStatus() != entregaAtualizada.getStatus()) {
                entrega.setStatus(entregaAtualizada.getStatus());
                entrega.adicionarMovimentacao("Atualicação manual de dados e status", "N/A", "N/A");
            }


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
