package com.poo.aulaspring.controller;

import com.poo.aulaspring.model.Cliente;
import com.poo.aulaspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }


    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){

        return clienteService.criarCliente(cliente);
    }

}
