package io.github.px86.rabbitmq.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  public static final String EXCHANGE_NAME = "demo.exchange";
  public static final String QUEUE_NAME = "demo.queue";
  public static final String ROUTING_KEY = "demo.#";

  @Bean
  public TopicExchange exchange() {
    return ExchangeBuilder.topicExchange(EXCHANGE_NAME).build();
  }

  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME);
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
  }
}
