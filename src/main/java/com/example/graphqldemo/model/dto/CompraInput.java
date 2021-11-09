package com.example.graphqldemo.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CompraInput {

    private Long id;

    private Date data;

    private Integer quantidade;

    private String status;

    private Long clienteId;

    private Long produtoId;
}
