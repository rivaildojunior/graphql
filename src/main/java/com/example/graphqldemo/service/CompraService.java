package com.example.graphqldemo.service;

import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.repository.CompraRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {


    private CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Transactional
    public Compra save(Compra compra){
        return compraRepository.save(compra);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if (compraRepository.findById(id).isPresent()){
            compraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
