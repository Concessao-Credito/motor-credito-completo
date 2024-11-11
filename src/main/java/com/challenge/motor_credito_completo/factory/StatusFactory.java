package com.challenge.motor_credito_completo.factory;

import com.challenge.motor_credito_completo.domain.StatusEnum;
import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class StatusFactory {

    private static final Random random = new Random();

    public static StatusEnum getRandomStatus() {
        StatusEnum[] statuses = StatusEnum.values();
        int index = random.nextInt(statuses.length);
        return statuses[index];
    }
}
