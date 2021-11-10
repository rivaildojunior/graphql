package com.example.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.model.Produto;
import com.example.graphqldemo.service.ClienteService;
import com.example.graphqldemo.service.ProdutoService;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    private ClienteService clienteService;
    private ProdutoService produtoService;

    public CompraResolver(ClienteService clienteService, ProdutoService produtoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public Cliente cliente(Compra compra) {
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto produto(Compra compra) {
        return produtoService.findById(compra.getProduto().getId());
    }
}
