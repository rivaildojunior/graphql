package com.example.graphqldemo.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqldemo.model.Produto;
import com.example.graphqldemo.model.dto.ProdutoInput;
import com.example.graphqldemo.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {


    private ProdutoService produtoService;

    public ProdutoGraphQL(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public Produto produto(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput input){
        ModelMapper modelMapper = new ModelMapper();
        Produto produto = modelMapper.map(input, Produto.class);
        return produtoService.save(produto);
    }

    public Boolean deleteProduto(Long id) {
        return produtoService.deleteById(id);
    }
}
