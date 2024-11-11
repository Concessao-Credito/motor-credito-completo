package com.challenge.motor_credito_completo.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CaptacaoCompletaRequest {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String rg;
    private String cep;
    private String endereco;
    private String profissao;
    private BigDecimal renda;
}
