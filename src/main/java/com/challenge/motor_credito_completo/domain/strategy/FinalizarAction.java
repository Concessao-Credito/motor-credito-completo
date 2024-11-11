package com.challenge.motor_credito_completo.domain.strategy;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.domain.CaptacaoRequest;
import com.challenge.motor_credito_completo.domain.ClienteRequest;
import com.challenge.motor_credito_completo.domain.StatusEnum;
import com.challenge.motor_credito_completo.publisher.CaptacaoProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FinalizarAction implements ActionStrategy {
    private final CaptacaoProducer captacaoProducer;
    private final ModelMapper mapper;

    @Override
    public void execute(CaptacaoCompletaRequest request, StatusEnum statusEnum) {
        log.info("Informações do cliente inadimplentes, enviar para o topico de persistencia e notificacao");
        ClienteRequest clienteRequest = mapper.map(request, ClienteRequest.class);

        CaptacaoRequest captacaoRequest = CaptacaoRequest
                .builder()
                .statusEnum(statusEnum)
                .clienteRequest(clienteRequest)
                .propostaRequest(null)
                .build();

        captacaoProducer
                .sendMessage(captacaoRequest);
    }
}
