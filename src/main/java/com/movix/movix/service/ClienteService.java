package com.movix.movix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movix.movix.entity.Cliente;
import com.movix.movix.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente>listarTodos() {
        return clienteRepository.findAll();
    }
    public Optional<Cliente>buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setCep(clienteAtualizado.getCep());
            cliente.setLogradouro(clienteAtualizado.getLogradouro());
            cliente.setNumero(clienteAtualizado.getNumero());
            cliente.setComplemento(clienteAtualizado.getComplemento());
            cliente.setPontoReferencia(clienteAtualizado.getPontoReferencia());
            cliente.setBairro(clienteAtualizado.getBairro());
            cliente.setCidade(clienteAtualizado.getCidade());
            cliente.setEstado(clienteAtualizado.getEstado());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

}
