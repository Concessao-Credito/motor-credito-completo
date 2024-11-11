package com.challenge.motor_credito_completo.listerner;

import com.challenge.motor_credito_completo.config.RabbitMQConfig;
import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.service.MotorCreditoCompletoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CaptacaoCompletaConsumer {
    private final MotorCreditoCompletoService service;

    @RabbitListener(queues = RabbitMQConfig.CAPTACAO_COMPLETA_CONCUIDA_QUEUE)
    public void receiveMessage(CaptacaoCompletaRequest message) {
        log.info("Iniciando o processamento dos dados de captacao completa");
        service.process(message);
    }
}
