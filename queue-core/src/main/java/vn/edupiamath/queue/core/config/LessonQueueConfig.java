package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LessonQueueConfig extends CoreQueueConfig {
    //  ====> Lesson queue <====
    @Value("${spring.application.queue.lesson.dead-name}")
    public String queueLessonDead;
    @Value("${spring.application.queue.lesson.dead-key}")
    public String queueLessonDeadKey;
    @Value("${spring.application.queue.lesson.name}")
    public String queueLesson;
    @Value("${spring.application.queue.lesson.key}")
    public String queueLessonKey;

    //  ====> START Course queue <====
    @Bean
    Queue lessonDLQ() {
        return QueueBuilder.durable(queueLessonDead).build();
    }

    @Bean
    Binding lessonDLQBinding() {
        return BindingBuilder.bind(lessonDLQ()).to(deadLetterExchange()).with(queueLessonDeadKey);
    }

    @Bean
    Queue lessonQueue() {
        return QueueBuilder.durable(queueLesson)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueLessonDeadKey)
                .build();
    }

    @Bean
    Binding lessonQueueBinding() {
        return BindingBuilder.bind(lessonQueue()).to(exchange()).with(queueLessonKey);
    }
}
