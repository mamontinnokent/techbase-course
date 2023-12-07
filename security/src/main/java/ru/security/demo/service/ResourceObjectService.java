package ru.security.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.security.demo.domain.resourceobject.entity.ResourceObjectEntity;
import ru.security.demo.domain.resourceobject.model.ResourceObject;
import ru.security.demo.repository.ResourceObjectRepository;

@Service
@RequiredArgsConstructor
public class ResourceObjectService {

    private final ResourceObjectRepository repository;

    public Integer save(ResourceObject resourceObject) {
        return repository
                .save(new ResourceObjectEntity(
                        resourceObject.getId(), resourceObject.getValue(), resourceObject.getPath()))
                .getId();
    }

    public ResourceObject get(int id) {
        return repository
                .findById(id)
                .map(r -> new ResourceObject(r.getId(), r.getValue(), r.getPath()))
                .orElse(null);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
