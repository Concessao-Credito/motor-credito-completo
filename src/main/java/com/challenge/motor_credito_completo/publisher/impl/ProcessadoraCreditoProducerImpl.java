package com.challenge.motor_credito_completo.publisher.impl;

import com.challenge.motor_credito_completo.config.RabbitMQConfig;
import com.challenge.motor_credito_completo.domain.ClienteRequest;
import com.challenge.motor_credito_completo.publisher.ProcessadoraCreditoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessadoraCreditoProducerImpl implements ProcessadoraCreditoProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(ClienteRequest message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.APP_EXCHANGE, RabbitMQConfig.MOTOR_COMPLETO_CONCLUIDO_ROUTING_KEY, message);
    }
}
