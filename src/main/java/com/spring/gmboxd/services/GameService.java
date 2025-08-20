package com.spring.gmboxd.services;

import com.spring.gmboxd.dtos.GameMinDTO;
import com.spring.gmboxd.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }
}
