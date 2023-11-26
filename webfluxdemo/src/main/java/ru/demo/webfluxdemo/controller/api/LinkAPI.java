package ru.demo.webfluxdemo.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.demo.webfluxdemo.controller.model.LinkDto;

public interface LinkAPI {
  @PostMapping("/save")
  Mono<ResponseEntity<String>> save(@RequestBody LinkDto dto);

  @GetMapping("/{shortLink}")
  Mono<ResponseEntity<Void>> redirect(@RequestParam("shortLink") String shortLink);
}
