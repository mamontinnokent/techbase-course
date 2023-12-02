package ru.security.demo.demo.repository;

import com.dhabits.ss.demo.domain.entity.*;
import com.dhabits.ss.demo.domain.entity.ResourceObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceObjectRepository extends JpaRepository<ResourceObjectEntity, Integer> {
}
