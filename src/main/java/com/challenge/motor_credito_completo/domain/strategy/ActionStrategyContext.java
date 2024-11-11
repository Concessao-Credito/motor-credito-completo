package com.challenge.motor_credito_completo.domain.strategy;

import com.challenge.motor_credito_completo.domain.CaptacaoCompletaRequest;
import com.challenge.motor_credito_completo.domain.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Component
@Slf4j
public class ActionStrategyContext {

    private static final String ERROR_MESSAGE = "Unsupported action {} ";

    private final Map<StatusEnum, ActionStrategy> strategyMap = new EnumMap<>(StatusEnum.class);

    public ActionStrategyContext(FinalizarAction finalizarAction, SeguirAction seguirAction) {
        strategyMap.put(StatusEnum.APROVADO, seguirAction);
        strategyMap.put(StatusEnum.COM_ERRO, finalizarAction);
        strategyMap.put(StatusEnum.REPROVADO, finalizarAction);
    }

    public void executeStrategy(StatusEnum action, CaptacaoCompletaRequest request) {
        try {
            var strategy = strategyMap.get(action);
            if (nonNull(strategy)) {
                strategy.execute(request, action);
            }
        } catch (Exception e) {
            log.error(ERROR_MESSAGE, action, e);
            throw new UnsupportedOperationException(ERROR_MESSAGE + action);
        }
    }

}