package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FireBaseTokenQueueConfig extends CoreQueueConfig {

    // ===> fire base queue <===
    @Value("${spring.application.queue.firebase-token.dead-name}")
    public String firebaseTokenQueueDead;
    @Value("${spring.application.queue.firebase-token.dead-key}")
    public String firebaseTokenQueueDeadKey;
    @Value("${spring.application.queue.firebase-token.name}")
    public String firebaseTokenQueue;
    @Value("${spring.application.queue.firebase-token.key}")
    public String firebaseTokenQueueKey;

    // ====> Start Firebase Token
    @Bean
    Queue firebaseTokenDLQ() {
        return QueueBuilder.durable(firebaseTokenQueueDead).build();
    }

    @Bean
    Binding firebaseTokenDLQBinding() {
        return BindingBuilder.bind(firebaseTokenDLQ()).to(deadLetterExchange()).with(firebaseTokenQueueDeadKey);
    }

    @Bean
    Queue firebaseTokenQueue() {
        return QueueBuilder.durable(firebaseTokenQueue)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", firebaseTokenQueueDeadKey)
                .build();
    }

    @Bean
    Binding firebaseTokenQueueBinding() {
        return BindingBuilder.bind(firebaseTokenQueue()).to(exchange()).with(firebaseTokenQueueKey);
    }
}
