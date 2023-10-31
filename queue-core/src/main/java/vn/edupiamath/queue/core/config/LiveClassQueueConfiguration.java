package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiveClassQueueConfiguration extends CoreQueueConfig {

    //  ====> Register Live Class queue <====
    @Value("${spring.application.queue.register-live-class.dead-name}")
    public String queueRegisterLiveClassDead;
    @Value("${spring.application.queue.register-live-class.dead-key}")
    public String queueRegisterLiveClassDeadKey;
    @Value("${spring.application.queue.register-live-class.name}")
    public String queueRegisterLiveClass;
    @Value("${spring.application.queue.register-live-class.key}")
    public String queueRegisterLiveClassKey;

    //  ====> START Register Live Class queue <====
    @Bean
    Queue registerLiveClassDLQ() {
        return QueueBuilder.durable(queueRegisterLiveClassDead).build();
    }

    @Bean
    Binding registerLiveClassDLQBinding() {
        return BindingBuilder.bind(registerLiveClassDLQ()).to(deadLetterExchange()).with(queueRegisterLiveClassDeadKey);
    }

    @Bean
    Queue registerLiveClassQueue() {
        return QueueBuilder.durable(queueRegisterLiveClass)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueRegisterLiveClassDeadKey)
                .build();
    }

    @Bean
    Binding registerLiveClassQueueBinding() {
        return BindingBuilder.bind(registerLiveClassQueue()).to(exchange()).with(queueRegisterLiveClassKey);
    }
}
