package com.poo.aulaspring.repository;

import com.poo.aulaspring.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
