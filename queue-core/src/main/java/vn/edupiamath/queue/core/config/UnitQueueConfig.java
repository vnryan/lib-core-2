package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnitQueueConfig extends CoreQueueConfig {

    //  ====> Unit queue <====
    @Value("${spring.application.queue.unit.dead-name}")
    public String queueUnitDead;
    @Value("${spring.application.queue.unit.dead-key}")
    public String queueUnitDeadKey;
    @Value("${spring.application.queue.unit.name}")
    public String queueUnit;
    @Value("${spring.application.queue.unit.key}")
    public String queueUnitKey;

    //  ====> START Unit queue <====
    @Bean
    Queue unitDLQ() {
        return QueueBuilder.durable(queueUnitDead).build();
    }

    @Bean
    Binding unitDLQBinding() {
        return BindingBuilder.bind(unitDLQ()).to(deadLetterExchange()).with(queueUnitDeadKey);
    }

    @Bean
    Queue unitQueue() {
        return QueueBuilder.durable(queueUnit)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueUnitDeadKey)
                .build();
    }

    @Bean
    Binding unitQueueBinding() {
        return BindingBuilder.bind(unitQueue()).to(exchange()).with(queueUnitKey);
    }
}
