package io.github.px86.rabbitmq.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.px86.rabbitmq.demo"})
public class RabbitmqDemoConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqDemoConsumerApplication.class, args);
  }
}
