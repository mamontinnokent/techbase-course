package ru.demo.webfluxdemo.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {
  @Id UUID id;
  String link;
  String shortLink;
  LocalDateTime validity;
}
