package com.example.graphqldemo.service;

import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.model.dto.CompraResumo;
import com.example.graphqldemo.repository.CompraRepository;
import org.springframework.data.domain.Pageable;
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

    public List<Compra> findAll(Pageable pageable) {
        return compraRepository.findAll(pageable).getContent();
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

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return compraRepository.findAllComprasRelatorio();
    }
}
