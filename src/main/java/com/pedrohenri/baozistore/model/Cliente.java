package com.pedrohenri.baozistore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

//Transforma persistível
@Entity
public class Cliente {
    //Define campo de chave primária
    @Id
    //Define responsabilidade da definição da chave primária
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate clienteDesde;

    public Cliente(){}

    // getters and setters
    public void setId(Long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setClienteDesde(LocalDate clienteDesde){
        this.clienteDesde = clienteDesde;
    }

    public LocalDate getClienteDesde(){
        return clienteDesde;
    }

}
