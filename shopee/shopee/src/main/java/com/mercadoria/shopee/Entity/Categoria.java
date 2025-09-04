package com.mercadoria.shopee.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoriaid")
    private List<Mercadoria> mercadorias;

    public Categoria(){
    }
    public Categoria(UUID id, String nome, String descricao, List<Mercadoria> mercadorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.mercadorias = mercadorias;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }

}
