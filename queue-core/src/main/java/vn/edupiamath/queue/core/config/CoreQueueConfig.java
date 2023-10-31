package vn.edupiamath.queue.core.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreQueueConfig {

    @Value("${spring.application.exchange.edupia-math.dead-name}")
    public String mathExchangeDead;
    @Value("${spring.application.exchange.edupia-math.name}")
    public String mathExchange;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    DirectExchange deadLetterExchange() {
        return new DirectExchange(mathExchangeDead);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(mathExchange);
    }
}
