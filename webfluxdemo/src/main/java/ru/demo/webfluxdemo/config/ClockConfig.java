package ru.demo.webfluxdemo.config;

import java.time.Clock;
import java.time.ZoneId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfig {
  @Bean
  public Clock clock() {
    return Clock.system(ZoneId.of("Europe/Moscow"));
  }
}
