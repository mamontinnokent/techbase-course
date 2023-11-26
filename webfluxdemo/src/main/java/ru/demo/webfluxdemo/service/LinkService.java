package ru.demo.webfluxdemo.service;

import reactor.core.publisher.Mono;

public interface LinkService {
  Mono<String> createAndSaveShortLink(String link, String validity);

  Mono<String> getLink(String shortLink);
}
