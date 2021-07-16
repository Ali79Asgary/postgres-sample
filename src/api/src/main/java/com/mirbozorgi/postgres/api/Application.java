package com.mirbozorgi.postgres.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.mirbozorgi.postgres")
@EntityScan(basePackages = {"com.mirbozorgi.postgresql.core.entity"})
@EnableJpaRepositories(basePackages = "com.mirbozorgi.postgres.core.repository")
@EnableScheduling
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }
}
