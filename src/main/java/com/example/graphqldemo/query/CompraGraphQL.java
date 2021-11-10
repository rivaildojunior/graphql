package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.model.dto.CompraInput;
import com.example.graphqldemo.model.dto.CompraResumo;
import com.example.graphqldemo.service.ClienteService;
import com.example.graphqldemo.service.CompraService;
import com.example.graphqldemo.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {


    private CompraService compraService;
    private ClienteService clienteService;
    private ProdutoService produtoService;

    public CompraGraphQL(CompraService compraService,
                         ClienteService clienteService,
                         ProdutoService produtoService) {
        this.compraService = compraService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> compras() {
        return compraService.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper modelMapper = new ModelMapper();
        Compra compra = modelMapper.map(input, Compra.class);

        compra.setData(new Date());
        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));

        return compraService.save(compra);
    }

    public Boolean deleteCompra(Long id) {
        return compraService.deleteById(id);
    }

    public List<CompraResumo> getComprasRelatorio() {
        return compraService.findAllComprasRelatorio();
    }
}
