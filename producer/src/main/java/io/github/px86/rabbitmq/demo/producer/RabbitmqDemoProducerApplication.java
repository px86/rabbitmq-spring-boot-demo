package io.github.px86.rabbitmq.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.px86.rabbitmq.demo"})
public class RabbitmqDemoProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqDemoProducerApplication.class, args);
  }
}
