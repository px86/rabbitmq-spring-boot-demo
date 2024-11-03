package io.github.px86.rabbitmq.demo.producer;

import io.github.px86.rabbitmq.demo.MyMessage;
import io.github.px86.rabbitmq.demo.RabbitMQConfig;

import java.util.Date;
import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ProducerController {

  private RabbitTemplate rabbitTemplate;

  @Autowired
  public ProducerController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @PostMapping("/publish")
  public String publish(@RequestBody MyMessage message) {
    message.setId(UUID.randomUUID().toString());
    message.setDate(new Date());
    rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, message);
    return String.format("Message published with body=%s", message.getBody());
  }
}
