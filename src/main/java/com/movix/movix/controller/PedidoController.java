package com.movix.movix.controller;

import com.movix.movix.entity.Pedido;
import com.movix.movix.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Pedido salvar(@RequestBody @Valid Pedido pedido) {
        return service.salvar(pedido);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable @Valid Long id, @RequestBody Pedido pedido) {
        return service.atualizar(id, pedido);
    }

    @GetMapping("/rastreio/{codigo}")
    public Pedido rastrear(@PathVariable String codigo) {
        return service.buscarPorCodigoRastreio(codigo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
