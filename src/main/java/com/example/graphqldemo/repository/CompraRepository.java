package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);
}
