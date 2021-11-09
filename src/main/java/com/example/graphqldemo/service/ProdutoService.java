package com.example.graphqldemo.service;

import com.example.graphqldemo.model.Produto;
import com.example.graphqldemo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if (produtoRepository.findById(id).isPresent()){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
