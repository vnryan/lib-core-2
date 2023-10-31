package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationQueueConfig extends CoreQueueConfig {

    //  ====> Notification queue <====
    @Value("${spring.application.queue.notification.dead-name}")
    public String queueNotificationDead;
    @Value("${spring.application.queue.notification.dead-key}")
    public String queueNotificationDeadKey;
    @Value("${spring.application.queue.notification.name}")
    public String queueNotification;
    @Value("${spring.application.queue.notification.key}")
    public String queueNotificationKey;

    //  ====> START Notification queue <====
    @Bean
    Queue notificationDLQ() {
        return QueueBuilder.durable(queueNotificationDead).build();
    }

    @Bean
    Binding notificationDLQBinding() {
        return BindingBuilder.bind(notificationDLQ()).to(deadLetterExchange()).with(queueNotificationDeadKey);
    }

    @Bean
    Queue notificationQueue() {
        return QueueBuilder.durable(queueNotification)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueNotificationDeadKey)
                .build();
    }

    @Bean
    Binding notificationQueueBinding() {
        return BindingBuilder.bind(notificationQueue()).to(exchange()).with(queueNotificationKey);
    }
}
