package ru.demo.webfluxdemo.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShortLinkGenerator {

  String values = "abcdefghijklmnopqrstuvwxyzZYXWVUTSRQPONMLKJIHGFEDCBA";
  Random generatorNbrs = new Random(values.length());

  public String generateShortLink() {
    return IntStream.range(0, 10)
            .mapToObj(value -> values.charAt(generatorNbrs.nextInt()))
            .map(Object::toString)
            .collect(Collectors.joining());
  }
}
