package com.movix.movix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movix.movix.entity.Entrega;
import com.movix.movix.service.EntregaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/entregas")
@CrossOrigin(origins = "*")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }
    @GetMapping
    public List<Entrega> listarTodas() {
        return entregaService.listarTodas();
    }
    @GetMapping("/{id}")
    public Optional<Entrega> buscarPorId(@PathVariable Long id) {
        return entregaService.buscarPorId(id);
    }
    @PostMapping
    public Entrega salvar(@RequestBody @Valid Entrega entrega) {
        return entregaService.salvar(entrega);
    }
    @PutMapping("/{id}")
    public Entrega atualizar(@PathVariable @Valid Long id, @RequestBody Entrega entrega) {
        return entregaService.atualizar(id, entrega);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        entregaService.deletar(id);
    }

}
