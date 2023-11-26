package ru.demo.webfluxdemo.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.demo.webfluxdemo.repository.LinkRepository;

@Service
public class DefaultLinkService implements LinkService {

  LinkRepository repository;
  ShortLinkGenerator generator;
  ValidityParser validityParser;

  @Override
  public Mono<String> createAndSaveShortLink(String link, String validity) {
    return null;
  }

  @Override
  public Mono<String> getLink(String shortLink) {
    return null;
  }
}
