package ru.demo.webfluxdemo.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.demo.webfluxdemo.controller.api.LinkAPI;
import ru.demo.webfluxdemo.controller.model.LinkDto;
import ru.demo.webfluxdemo.service.LinkService;

@RestController("v1/")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LinkController implements LinkAPI {

  LinkService service;

  @Override
  public Mono<ResponseEntity<String>> save(LinkDto dto) {
    return service.createAndSaveShortLink(dto.getLink(), dto.getValidity()).map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> redirect(String shortLink) {
    return service
        .getLink(shortLink)
        .map(
            fullLink ->
                ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                    .header(HttpHeaders.LOCATION, fullLink)
                    .build());
  }
}
