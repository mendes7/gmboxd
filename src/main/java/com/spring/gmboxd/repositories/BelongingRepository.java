package com.spring.gmboxd.repositories;

import com.spring.gmboxd.entities.Belonging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BelongingRepository extends JpaRepository<Belonging, UUID> {
}
