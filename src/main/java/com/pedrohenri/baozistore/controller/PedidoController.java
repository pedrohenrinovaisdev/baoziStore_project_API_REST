package com.pedrohenri.baozistore.controller;


import com.pedrohenri.baozistore.model.Pedido;
import com.pedrohenri.baozistore.repository.ClienteRepository;
import com.pedrohenri.baozistore.repository.PedidoRepository;
import com.pedrohenri.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    //Injeção dos repositórios
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    //Novo pedido
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pedido criarPedido(@RequestBody Pedido pedido){
        Integer quantidade = pedido.getQuantidade();
        Long clienteId = pedido.getClienteId();
        Long produtoId = pedido.getProdutoId();
        if (pedido.getClienteId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (produtoId == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (quantidade == null || quantidade <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (!clienteRepository.existsById(clienteId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (!produtoRepository.existsById(produtoId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return pedidoRepository.save(pedido);
    }

    //Listar todos os pedidos
    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    //Pesquisa por id de pedido
    @GetMapping("/{id}")
    public Pedido consultaPedidoId(@PathVariable Long id){
        var pedido = pedidoRepository.findById(id);
        if (pedido.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return pedido.get();
    }

    //Deletar pedido por id
    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.NO_CONTENT)
    public void deletarPedidoId(@PathVariable Long id){
        var pedido = pedidoRepository.findById(id);
        if(pedido.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pedidoRepository.delete(pedido.get());
    }

}
