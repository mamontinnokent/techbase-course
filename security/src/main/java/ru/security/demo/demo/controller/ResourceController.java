package ru.security.demo.demo.controller;

import com.dhabits.ss.demo.domain.model.*;
import com.dhabits.ss.demo.domain.model.ResourceObject;
import com.dhabits.ss.demo.service.*;
import com.dhabits.ss.demo.service.ResourceObjectService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
