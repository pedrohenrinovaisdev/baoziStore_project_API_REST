package com.pedrohenri.baozistore.controller;


import com.pedrohenri.baozistore.model.Produto;
import com.pedrohenri.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //Cadastrar produto
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    //Listar produto
    @GetMapping
    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    //Pesquisar produto por ID
    @GetMapping("/{id}")
    public Produto pesquisarProdutoID(@PathVariable Long id){
        var produto = produtoRepository.findById(id);
        //Caso de produto não encontrado, retornar response Not_found
        if (produto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return produto.get();
    }

    //Deletar produto
    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id){
        var produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produtoRepository.delete(produto.get());
    }

}


















