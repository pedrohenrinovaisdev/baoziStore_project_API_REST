package com.pedrohenri.baozistore.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //Definindo propriedades especificas de coluna
    @Column(name = "preco", precision = 5, scale = 2)
    private BigDecimal preco;

    private Boolean estoque;

    public Produto(){}

    //getters and setters
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setPreco(BigDecimal preco){
        this.preco = preco;
    }
    public BigDecimal getPreco(){
        return preco;
    }

    public void setEstoque(Boolean estoque){
        this.estoque = estoque;
    }
    public Boolean getEstoque(){
        return estoque;
    }

}
