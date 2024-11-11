package com.challenge.motor_credito_completo.service.impl;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.domain.StatusEnum;
import com.challenge.motor_credito_completo.domain.strategy.ActionStrategyContext;
import com.challenge.motor_credito_completo.service.MotorCreditoCompletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.challenge.motor_credito_completo.factory.StatusFactory.getRandomStatus;

@Service
@RequiredArgsConstructor
public class MotorCreditoCompletoServiceImpl implements MotorCreditoCompletoService {

    private final ActionStrategyContext actionStrategyContext;

    @Override
    public void process(CaptacaoCompletaRequest message) {
        StatusEnum randomStatus = getRandomStatus();
        actionStrategyContext.executeStrategy(randomStatus, message);
    }
}
