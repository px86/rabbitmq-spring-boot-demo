package io.github.px86.rabbitmq.demo.consumer;

import io.github.px86.rabbitmq.demo.MyMessage;
import io.github.px86.rabbitmq.demo.RabbitMQConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
  private static final Logger log = LoggerFactory.getLogger(Consumer.class);

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
  public void handleMessage(String message) throws Exception {
    MyMessage myMessage = objectMapper().readValue(message, MyMessage.class);
    log.info("Received message: {}", myMessage.getBody());
  }
}
