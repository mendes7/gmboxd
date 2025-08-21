package com.spring.gmboxd.repositories;

import com.spring.gmboxd.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameListRepository extends JpaRepository<GameList, UUID> {
}
