package com.poo.aulaspring.repository;

import com.poo.aulaspring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findByNome(String nome);
}
