package com.challenge.motor_credito_completo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String APP_EXCHANGE = "appExchange";
    public static final String CAPTACAO_COMPLETA_CONCUIDA_QUEUE = "captacao_completa_concluida";
    public static final String MOTOR_CREDITO_P2_CONCLUIDO_QUEUE = "motor_credito_p2_concluido";
    public static final String MOTOR_COMPLETO_CONCLUIDO_ROUTING_KEY = "motor.completo.concluido.key";

    public static final String NOTIFICACAO_CAPTACAO_INVALIDA_NAME = "notificacao_captacao_invalida";
    public static final String NOTIFICACAO_CAPTACAO_INVALIDA_ROUTING_KEY = "notificacao.#";


    @Bean
    public Queue captacaoCompletaConcluidaQueue() {
        return new Queue(CAPTACAO_COMPLETA_CONCUIDA_QUEUE, true);
    }

    @Bean
    public Queue motorCreditoP2ConcluidoQueue() {
        return new Queue(MOTOR_CREDITO_P2_CONCLUIDO_QUEUE, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(APP_EXCHANGE);
    }

    @Bean
    public Binding motorCreditoP2ConcluidoQueueBinding(Queue motorCreditoP2ConcluidoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(motorCreditoP2ConcluidoQueue).to(exchange).with(MOTOR_COMPLETO_CONCLUIDO_ROUTING_KEY);
    }

    @Bean
    public Queue notificacaoCaptacaoInvalidaQueue() {
        return new Queue(NOTIFICACAO_CAPTACAO_INVALIDA_NAME, true);
    }

    @Bean
    public Binding notificacaoCaptacaoInvalidaBinding(Queue notificacaoCaptacaoInvalidaQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificacaoCaptacaoInvalidaQueue).to(exchange).with(NOTIFICACAO_CAPTACAO_INVALIDA_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
