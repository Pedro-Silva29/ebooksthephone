package com.poo.aulaspring.repository;

import com.poo.aulaspring.model.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EbookRepository extends JpaRepository<Ebook, Long> {

    public Ebook findByTitulo(String titulo);
}
