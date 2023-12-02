package ru.security.demo.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.security.demo.demo.domain.resourceobject.model.ResourceObject;
import ru.security.demo.demo.service.ResourceObjectService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceObjectService service;

    @PostMapping
    public ResponseEntity<Integer> createResourceObject(@RequestBody ResourceObject object) {
        val result = service.save(object);
        return ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceObject> getResourceObject(@PathVariable Integer id) {
        return ok(service.get(id));
    }

}
