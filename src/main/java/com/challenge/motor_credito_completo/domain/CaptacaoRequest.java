package com.challenge.motor_credito_completo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptacaoRequest {
    private ClienteRequest clienteRequest;
    private PropostaRequest propostaRequest;
    private StatusEnum statusEnum;
}
