package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email){
        return clienteService.save(new Cliente(id, nome, email));
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }
}
