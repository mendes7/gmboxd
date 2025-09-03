package com.spring.gmboxd.repositories;

import com.spring.gmboxd.entities.Game;
import com.spring.gmboxd.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {

    @Query(nativeQuery = true, value =
		"""
        SELECT CAST(tb_game.id AS VARCHAR) AS id,
               tb_game.title,
               tb_game.game_year AS gameYear,
               tb_game.img_url AS imgUrl,
               tb_game.short_description AS shortDescription,
               tb_belonging.position
        FROM tb_game
        INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
        WHERE tb_belonging.list_id = :listId
        ORDER BY tb_belonging.position
        """)
    List<GameMinProjection> searchByList(UUID listId);
}
