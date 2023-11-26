package ru.demo.webfluxdemo.repository;

import java.util.UUID;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import ru.demo.webfluxdemo.entity.Link;

@Repository
public interface LinkRepository extends R2dbcRepository<Link, UUID> {}
