package com.movix.movix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.movix.movix.entity.Cliente;
import com.movix.movix.service.ClienteService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> ListarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return service.salvar(cliente);
    }
    @GetMapping("/{id}")
    public Optional<Cliente>buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable @Valid Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
