package ru.demo.webfluxdemo.service;

import reactor.core.publisher.Mono;

public class DefaultLinkService implements LinkService {
  @Override
  public Mono<String> createAndSaveShortLink(String link, String validity) {
    return null;
  }

  @Override
  public Mono<String> getLink(String shortLink) {
    return null;
  }
}
