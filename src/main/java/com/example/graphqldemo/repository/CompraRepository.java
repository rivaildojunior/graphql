package com.example.graphqldemo.repository;

import com.example.graphqldemo.model.Cliente;
import com.example.graphqldemo.model.Compra;
import com.example.graphqldemo.model.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);

    @Query("select new com.example.graphqldemo.model.dto.CompraResumo(c.id,cli.nome,p.nome,c.quantidade) " +
            "from Compra c " +
            "inner join c.cliente cli " +
            "inner join c.produto p")
    List<CompraResumo> findAllComprasRelatorio();
}
