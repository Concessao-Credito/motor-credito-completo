package com.challenge.motor_credito_completo.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PropostaRequest {
    private Boolean ativa;
    private BigDecimal valorLiberado;
}
