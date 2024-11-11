package com.challenge.motor_credito_completo.service;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;

public interface MotorCreditoCompletoService {
    void process(CaptacaoCompletaRequest message);
}
