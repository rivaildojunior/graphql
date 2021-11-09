package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
