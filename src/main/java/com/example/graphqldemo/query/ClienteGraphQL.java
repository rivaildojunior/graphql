package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.dto.ClienteInput;
import com.example.graphqldemo.service.ClienteService;
import org.modelmapper.ModelMapper;
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

    public Cliente saveCliente(ClienteInput input){
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(input, Cliente.class);
        return clienteService.save(cliente);
    }

    public Boolean deleteCliente(Long id) {
        return clienteService.deleteById(id);
    }
}
