package com.spring.gmboxd.dtos;

import com.spring.gmboxd.entities.GameList;

import java.util.UUID;

public class GameListDTO {

    private UUID id;
    private String name;

    public GameListDTO() {}

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
