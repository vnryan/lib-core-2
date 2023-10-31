package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration extends CoreQueueConfig {

    // ===> Register consult queue <===
    @Value("${spring.application.queue.register-consult.dead-name}")
    public String registerConsultQueueDead;
    @Value("${spring.application.queue.register-consult.dead-key}")
    public String registerConsultQueueDeadKey;
    @Value("${spring.application.queue.register-consult.name}")
    public String registerConsultQueue;
    @Value("${spring.application.queue.register-consult.key}")
    public String registerConsultQueueKey;

    // ===> User Register Trial queue <===
    @Value("${spring.application.queue.register-trial.dead-name}")
    public String registerTrialQueueDead;
    @Value("${spring.application.queue.register-trial.dead-key}")
    public String registerTrialQueueDeadKey;
    @Value("${spring.application.queue.register-trial.name}")
    public String registerTrialQueue;
    @Value("${spring.application.queue.register-trial.key}")
    public String registerTrialQueueKey;

    // ===> Create User Active queue <===
    @Value("${spring.application.queue.create-user-active.dead-name}")
    public String createUserActiveQueueDead;
    @Value("${spring.application.queue.create-user-active.dead-key}")
    public String createUserActiveQueueDeadKey;
    @Value("${spring.application.queue.create-user-active.name}")
    public String createUserActiveQueue;
    @Value("${spring.application.queue.create-user-active.key}")
    public String createUserActiveQueueKey;

    // ====> Start Register Consult queue
    @Bean
    Queue registerConsultDLQ() {
        return QueueBuilder.durable(registerConsultQueueDead).build();
    }

    @Bean
    Binding registerConsultDLQBinding() {
        return BindingBuilder.bind(registerConsultDLQ()).to(deadLetterExchange()).with(registerConsultQueueDeadKey);
    }

    @Bean
    Queue registerConsultQueue() {
        return QueueBuilder.durable(registerConsultQueue)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", registerConsultQueueDeadKey)
                .build();
    }

    @Bean
    Binding registerConsultQueueBinding() {
        return BindingBuilder.bind(registerConsultQueue()).to(exchange()).with(registerConsultQueueKey);
    }

    // ====> Start User Register Consult QUEUE
    @Bean
    Queue registerTrialDLQ() {
        return QueueBuilder.durable(registerTrialQueueDead).build();
    }

    @Bean
    Binding registerTrialDLQBinding() {
        return BindingBuilder.bind(registerTrialDLQ()).to(deadLetterExchange()).with(registerTrialQueueDeadKey);
    }

    @Bean
    Queue registerTrialQueue() {
        return QueueBuilder.durable(registerTrialQueue)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", registerTrialQueueDeadKey)
                .build();
    }

    @Bean
    Binding registerTrialQueueBinding() {
        return BindingBuilder.bind(registerTrialQueue()).to(exchange()).with(registerTrialQueueKey);
    }

    // ===> Create User Active <===
    @Bean
    Queue createUserActiveDLQ() {
        return QueueBuilder.durable(createUserActiveQueueDead).build();
    }

    @Bean
    Binding createUserActiveDLQBinding() {
        return BindingBuilder.bind(createUserActiveDLQ()).to(deadLetterExchange()).with(createUserActiveQueueDeadKey);
    }

    @Bean
    Queue createUserActiveQueue() {
        return QueueBuilder.durable(createUserActiveQueue)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", createUserActiveQueueDeadKey)
                .build();
    }

    @Bean
    Binding createUserActiveQueueBinding() {
        return BindingBuilder.bind(createUserActiveQueue()).to(exchange()).with(createUserActiveQueueKey);
    }
}
