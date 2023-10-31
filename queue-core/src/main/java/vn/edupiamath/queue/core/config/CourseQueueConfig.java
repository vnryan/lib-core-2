package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseQueueConfig extends CoreQueueConfig {
    //  ====> Course queue <====
    @Value("${spring.application.queue.course.dead-name}")
    public String queueCourseDead;
    @Value("${spring.application.queue.course.dead-key}")
    public String queueCourseDeadKey;
    @Value("${spring.application.queue.course.name}")
    public String queueCourse;
    @Value("${spring.application.queue.course.key}")
    public String queueCourseKey;

    //  ====> START Course queue <====
    @Bean
    Queue courseDLQ() {
        return QueueBuilder.durable(queueCourseDead).build();
    }

    @Bean
    Binding courseDLQBinding() {
        return BindingBuilder.bind(courseDLQ()).to(deadLetterExchange()).with(queueCourseDeadKey);
    }

    @Bean
    Queue courseQueue() {
        return QueueBuilder.durable(queueCourse)
                .withArgument("x-dead-letter-exchange", mathExchangeDead)
                .withArgument("x-dead-letter-routing-key", queueCourseDeadKey)
                .build();
    }

    @Bean
    Binding courseQueueBinding() {
        return BindingBuilder.bind(courseQueue()).to(exchange()).with(queueCourseKey);
    }
}
