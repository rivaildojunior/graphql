package com.example.graphqldemo.model.dto;

import lombok.Data;

@Data
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;
}
