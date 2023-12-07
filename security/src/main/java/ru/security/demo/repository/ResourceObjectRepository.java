package ru.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.security.demo.domain.resourceobject.entity.ResourceObjectEntity;

public interface ResourceObjectRepository extends JpaRepository<ResourceObjectEntity, Integer> {
    void deleteById(Integer id);
}
