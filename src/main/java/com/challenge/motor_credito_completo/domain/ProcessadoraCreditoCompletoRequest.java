package com.challenge.motor_credito_completo.domain;

import lombok.Data;

@Data
public class ProcessadoraCreditoCompletoRequest {
    private ClienteRequest clienteRequest;
    private PropostaRequest propostaRequest;
}
