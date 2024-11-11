package com.challenge.motor_credito_completo.domain.strategy;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.domain.StatusEnum;

public interface ActionStrategy {

    void execute(CaptacaoCompletaRequest request, StatusEnum statusEnum);

}
