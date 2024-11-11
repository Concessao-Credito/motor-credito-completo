package com.challenge.motor_credito_completo.publisher;

import com.challenge.motor_credito_completo.domain.CaptacaoRequest;

public interface CaptacaoProducer {
    void sendMessage(CaptacaoRequest message);
}
