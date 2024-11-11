package com.challenge.motor_credito_completo.publisher.impl;

import com.challenge.motor_credito_completo.config.RabbitMQConfig;
import com.challenge.motor_credito_completo.domain.CaptacaoRequest;
import com.challenge.motor_credito_completo.publisher.CaptacaoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptacaoProducerImpl implements CaptacaoProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(CaptacaoRequest message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.APP_EXCHANGE, RabbitMQConfig.NOTIFICACAO_CAPTACAO_INVALIDA_ROUTING_KEY, message);
    }
}
