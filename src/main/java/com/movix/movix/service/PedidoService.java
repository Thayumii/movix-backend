package com.movix.movix.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movix.movix.entity.Pedido;
import com.movix.movix.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public List<Pedido>listarTodos() {
        return pedidoRepository.findAll();
    }
    public Optional<Pedido>buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }
    public Pedido salvar(Pedido pedido) {
        calcularFrete(pedido);
        return pedidoRepository.save(pedido);
    }
    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setPeso(pedidoAtualizado.getPeso());
            pedido.setOrigem(pedidoAtualizado.getOrigem());
            pedido.setDestino(pedidoAtualizado.getDestino());
            pedido.setCliente(pedidoAtualizado.getCliente());
            calcularFrete(pedido);
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private void calcularFrete(Pedido pedido) {
        if (pedido.getPeso() == null || pedido.getPeso() <= 0) {
            pedido.setValorFrete(BigDecimal.ZERO);
            return;
        }
        BigDecimal pesoEmBigDecimal = BigDecimal.valueOf(pedido.getPeso());
        BigDecimal taxaPorQuilo = new BigDecimal("1.5");
        BigDecimal frete = pesoEmBigDecimal.multiply(taxaPorQuilo);

        pedido.setValorFrete(frete);
    }

}
