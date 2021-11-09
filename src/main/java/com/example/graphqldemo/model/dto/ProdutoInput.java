package com.example.graphqldemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoInput {  @Id

    private Long id;
    private String nome;
    private Float valor;
}
