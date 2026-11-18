package com.pedrohenri.baozistore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

//Transforma persistível
@Entity
public class Cliente {

    public Cliente(){

    }

    //Define campo de chave primária
    @Id
    //Define responsabilidade da definição da chave primária
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public LocalDate clienteDesde;

    // getters and setters
    private void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    private void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    private void setClienteDesde(LocalDate clienteDesde){
        this.clienteDesde = clienteDesde;
    }

    public LocalDate getClienteDesde(){
        return clienteDesde;
    }

}
