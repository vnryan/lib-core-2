package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeedbackQueueConfig extends CoreQueueConfig {

    // ===> Feedback queue <===
    @Value("${spring.application.queue.feedback.dead-name}")
    public String feedbackQueueDead;
    @Value("${spring.application.queue.feedback.dead-key}")
    public String feedbackQueueDeadKey;
    @Value("${spring.application.queue.feedback.name}")
    public String feedbackQueue;
    @Value("${spring.application.queue.feedback.key}")
    public String feedbackQueueKey;

    // ====> Start Feedback queue
    @Bean
    Queue feedbackDLQ() {
        return QueueBuilder.durable(feedbackQueueDead).build();
    }

    @Bean
    Binding feedbackDLQBinding() {
        return BindingBuilder.bind(feedbackDLQ()).to(deadLetterExchange()).with(feedbackQueueDeadKey);
    }

    @Bean
    Queue feedbackQueue() {
        return QueueBuilder.durable(feedbackQueue)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", feedbackQueueDeadKey)
                .build();
    }

    @Bean
    Binding feedbackQueueBinding() {
        return BindingBuilder.bind(feedbackQueue()).to(exchange()).with(feedbackQueueKey);
    }
}
