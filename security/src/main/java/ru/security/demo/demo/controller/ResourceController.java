package ru.security.demo.demo.controller;

import static org.springframework.http.ResponseEntity.ok;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.security.demo.demo.domain.resourceobject.model.ResourceObject;
import ru.security.demo.demo.service.ResourceObjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/resource")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceController {

    ResourceObjectService service;

    @PostMapping
    public ResponseEntity<Integer> createResourceObject(@RequestBody ResourceObject object) {
        val result = service.save(object);
        return ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Integer id) {
        service.delete(id);
        return ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceObject> getResourceObject(@PathVariable Integer id) {
        return ok(service.get(id));
    }
}
