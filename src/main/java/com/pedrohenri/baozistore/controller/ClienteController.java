package com.pedrohenri.baozistore.controller;

import com.pedrohenri.baozistore.model.Cliente;
import com.pedrohenri.baozistore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    //Endpoint cadastro de clientes
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //Endpoint listar clientes
    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    //Endpoint buscar clientes por id
    @GetMapping("/{id}")
    public Cliente buscaPorId(@PathVariable Long id){
        var cliente = clienteRepository.findById(id);
        //Caso de cliente não encontrado, retornar response Not_found
        if (cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cliente.get();
    }

    //Endpoint excluir clientes
    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.NO_CONTENT)
    public void deletarClienteId(@PathVariable Long id){
        var cliente = clienteRepository.findById(id);
        //Caso de cliente não encontrado, retornar response Not_found
        if (cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        clienteRepository.delete(cliente.get());
    }




}
