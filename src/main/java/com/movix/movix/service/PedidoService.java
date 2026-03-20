package com.movix.movix.service;

import com.movix.movix.entity.Entrega;
import com.movix.movix.entity.Motorista;
import com.movix.movix.entity.Pedido;
import com.movix.movix.entity.StatusEntrega;
import com.movix.movix.repository.EntregaRepository;
import com.movix.movix.repository.MotoristaRepository;
import com.movix.movix.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final MotoristaRepository motoristaRepository;
    private final EntregaRepository entregaRepository;

    public PedidoService(PedidoRepository pedidoRepository, MotoristaRepository motoristaRepository, EntregaRepository entregaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.motoristaRepository = motoristaRepository;
        this.entregaRepository = entregaRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional //se der erro na entrega o pedido não vai salvar sozinho
    public Pedido salvar(Pedido pedido) {

        pedido.setCodigoRastreio(gerarCodigoRastreioUnico());

        calcularFrete(pedido);

        Pedido pedidoSalvo = pedidoRepository.save(pedido); //salva o pedido primeiro.

        Optional<Motorista> motoristaOpt = motoristaRepository.findFirstByDisponivelTrue(); // tenta buscar um motorista.

        Entrega entrega = new Entrega();
        entrega.setPedido(pedidoSalvo);
        entrega.setCriadoEm(LocalDateTime.now());
        entrega.setDataPrevista(LocalDateTime.now().plusDays(5));

        if (motoristaOpt.isPresent()) {
            Motorista motorista = motoristaOpt.get();
            entrega.setMotorista(motorista);
            entrega.setStatus(StatusEntrega.CRIADO);

            motorista.setDisponivel(false);
            motoristaRepository.save(motorista);
        } else {
            entrega.setStatus(StatusEntrega.SEM_MOTORISTA);
        }
        entregaRepository.save(entrega);

        return pedidoSalvo;
    }

    private String gerarCodigoRastreioUnico() {
        String codigo;
        boolean jaExiste;
        do {
            codigo = "MVX" + UUID.randomUUID().toString().replace("-", "").substring(0, 9).toUpperCase();
            jaExiste = pedidoRepository.findByCodigoRastreio(codigo).isPresent();
        } while (jaExiste);
        return codigo;
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

    public Pedido buscarPorCodigoRastreio(String codigo) {
        return pedidoRepository.findByCodigoRastreio(codigo).orElseThrow(() -> new RuntimeException("Código de rastreio não encontrado."));
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