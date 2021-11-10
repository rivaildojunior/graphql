package com.example.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqldemo.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto) {
        return "R$" + produto.getValor();
    }
}
