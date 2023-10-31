package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogsLearnQueueConfig extends CoreQueueConfig {
    //  ====> Logs learn queue <====
    @Value("${spring.application.queue.logs-learn.dead-name}")
    public String queueLogsLearnDead;
    @Value("${spring.application.queue.logs-learn.dead-key}")
    public String queueLogsLearnDeadKey;
    @Value("${spring.application.queue.logs-learn.name}")
    public String queueLogsLearn;
    @Value("${spring.application.queue.logs-learn.key}")
    public String queueLogsLearnKey;

    //  ====> START LogsLearn queue <====
    @Bean
    Queue logsLearnDLQ() {
        return QueueBuilder.durable(queueLogsLearnDead).build();
    }

    @Bean
    Binding logsLearnDLQBinding() {
        return BindingBuilder.bind(logsLearnDLQ()).to(deadLetterExchange()).with(queueLogsLearnDeadKey);
    }

    @Bean
    Queue logsLearnQueue() {
        return QueueBuilder.durable(queueLogsLearn)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueLogsLearnDeadKey)
                .build();
    }

    @Bean
    Binding logsLearnQueueBinding() {
        return BindingBuilder.bind(logsLearnQueue()).to(exchange()).with(queueLogsLearnKey);
    }
}
