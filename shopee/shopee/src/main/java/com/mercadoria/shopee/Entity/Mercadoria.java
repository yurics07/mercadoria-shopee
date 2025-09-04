package com.mercadoria.shopee.Entity;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mercadoria")

public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    private UUID id;
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private Categoria categoriaid;

   @ManyToOne
   @JoinColumn(name = "fornecedor_id")
   private Fornecedor fornecedor;

   public Mercadoria(){
   }

    public Mercadoria(UUID id, String nome, double preco, int quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
