package com.spring.gmboxd.controllers;

import com.spring.gmboxd.dtos.GameListDTO;
import com.spring.gmboxd.dtos.GameMinDTO;
import com.spring.gmboxd.services.GameListService;
import com.spring.gmboxd.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable UUID listId) {
        return gameService.findByList(listId);
    }
}
