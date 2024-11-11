package com.challenge.motor_credito_completo.domain.strategy;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.domain.ClienteRequest;
import com.challenge.motor_credito_completo.domain.StatusEnum;
import com.challenge.motor_credito_completo.publisher.ProcessadoraCreditoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeguirAction implements ActionStrategy {

    private final ProcessadoraCreditoProducer processadoraCreditoProducer;
    private final ModelMapper mapper;

    @Override
    public void execute(CaptacaoCompletaRequest request, StatusEnum statusEnum) {
        log.info("Informações do cliente sem inadimplencias seguir para o topico de processadora de credito");
        ClienteRequest clienteRequest = mapper.map(request, ClienteRequest.class);
        processadoraCreditoProducer.sendMessage(clienteRequest);
    }
}
