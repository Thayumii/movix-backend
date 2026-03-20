package com.movix.movix.controller;

import com.movix.movix.entity.Motorista;
import com.movix.movix.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Motorista> ListarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Motorista salvar(@RequestBody @Valid Motorista motorista) {
        return service.salvar(motorista);
    }

    @GetMapping("/{id}")
    public Optional<Motorista> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
