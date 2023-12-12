package com.poo.aulaspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Conta> contas;

    public Cliente () {}

    public Cliente(String nome, ArrayList<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public ArrayList<Conta> getContas() {

        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {

        this.contas = contas;
    }
}
