package com.poo.aulaspring.service;

import com.poo.aulaspring.model.Cliente;
import com.poo.aulaspring.model.Conta;
import com.poo.aulaspring.repository.ClienteRepository;
import com.poo.aulaspring.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService{

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public Conta criarConta(Conta conta, Long idCliente){
        Optional<Cliente> optCliente = clienteRepository.findById(idCliente);

        if (optCliente.isEmpty()){
            return null;
        } else {
            optCliente.get().getContas().add(conta);
            conta.setCliente(optCliente.get());
            return contaRepository.save(conta);
        }
    }
}
