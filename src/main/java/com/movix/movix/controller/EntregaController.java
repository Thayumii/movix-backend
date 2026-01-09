package com.movix.movix.controller;

import com.movix.movix.DTO.AtualizarStatusRequest;
import com.movix.movix.entity.Entrega;
import com.movix.movix.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entregas")
@CrossOrigin(origins = "http://localhost:5173")
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

    @PatchMapping("/{id}/status")
    public Entrega atualizarStatus(@PathVariable Long id, @RequestBody AtualizarStatusRequest request) {
        return entregaService.atualizarStatus(id, request.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        entregaService.deletar(id);
    }

}
