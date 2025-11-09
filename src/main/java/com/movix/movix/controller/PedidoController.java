package com.movix.movix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movix.movix.entity.Pedido;
import com.movix.movix.service.PedidoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
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
    public Optional<Pedido>buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable @Valid Long id, @RequestBody Pedido pedido) {
        return service.atualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
