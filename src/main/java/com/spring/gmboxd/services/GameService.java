package com.spring.gmboxd.services;

import com.spring.gmboxd.dtos.GameDTO;
import com.spring.gmboxd.dtos.GameMinDTO;
import com.spring.gmboxd.entities.Game;
import com.spring.gmboxd.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(UUID id) {
        Game entity = gameRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
        return new GameDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(UUID listId) {
        return gameRepository.searchByList(listId)
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
