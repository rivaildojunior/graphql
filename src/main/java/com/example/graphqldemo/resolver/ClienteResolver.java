package com.example.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.service.CompraService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    private CompraService compraService;

    public ClienteResolver(CompraService compraService) {
        this.compraService = compraService;
    }

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }
}
