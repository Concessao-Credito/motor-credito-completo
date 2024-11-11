package com.challenge.motor_credito_completo.publisher;

import com.challenge.motor_credito_completo.domain.ClienteRequest;

public interface ProcessadoraCreditoProducer {
    void sendMessage(ClienteRequest message);
}
