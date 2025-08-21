package com.spring.gmboxd.config;

import com.spring.gmboxd.entities.Belonging;
import com.spring.gmboxd.entities.Game;
import com.spring.gmboxd.entities.GameList;
import com.spring.gmboxd.repositories.BelongingRepository;
import com.spring.gmboxd.repositories.GameListRepository;
import com.spring.gmboxd.repositories.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDataLoader implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final GameListRepository gameListRepository;
    private final BelongingRepository belongingRepository;

    public GameDataLoader(GameRepository gameRepository, GameListRepository gameListRepository, BelongingRepository belongingRepository) {
        this.gameRepository = gameRepository;
        this.gameListRepository = gameListRepository;
        this.belongingRepository = belongingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.count() == 0) {
            List<Game> games = List.of(
                    new Game("Mass Effect Trilogy", 2012, "RPG, Shooter", "XBox, Playstation, PC", 4.8,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
                            "Epic sci-fi RPG adventure.", "Experience the full Mass Effect saga with all three games combined."),
                    new Game("Red Dead Redemption 2", 2018, "RPG, Adventure", "XBox, Playstation, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png",
                            "Wild west open world RPG.", "Embark on an epic journey in the American frontier."),
                    new Game("The Witcher 3: Wild Hunt", 2014, "RPG, Adventure", "XBox, Playstation, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png",
                            "Fantasy open world RPG.", "Hunt monsters and explore a vast fantasy world as Geralt of Rivia."),
                    new Game("Sekiro: Shadows Die Twice", 2019, "RPG, Adventure", "XBox, Playstation, PC", 3.8,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png",
                            "Challenging action RPG.", "Master sword combat and stealth in feudal Japan."),
                    new Game("Ghost of Tsushima", 2012, "RPG, Adventure", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png",
                            "Open world samurai adventure.", "Fight against invaders and protect Tsushima Island."),
                    new Game("Super Mario World", 1990, "Platform", "Super NES, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png",
                            "Classic platformer.", "Guide Mario through levels to save Princess Peach."),
                    new Game("Hollow Knight", 2017, "Platform", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png",
                            "Metroidvania platformer.", "Explore a vast underground world full of secrets."),
                    new Game("Ori and the Blind Forest", 2015, "Platform", "XBox, Playstation, PC", 4.0,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png",
                            "Beautiful platform adventure.", "Follow Ori on a heartfelt journey through a magical forest."),
                    new Game("Cuphead", 2017, "Platform", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png",
                            "Challenging run-and-gun game.", "Fight bosses with unique hand-drawn animations."),
                    new Game("Sonic CD", 1993, "Platform", "Sega CD, PC", 4.0,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png",
                            "Classic Sonic platformer.", "Speed through levels and collect rings as Sonic.")
            );

            gameRepository.saveAll(games);
            System.out.println("Games inserted into H2 database!");
        }

        if (gameListRepository.count() == 0) {
            List<Game> allGames = gameRepository.findAll();

            GameList listRpgAdventure = new GameList("Adventure and RPG");
            GameList listPlatform = new GameList("Platform Games");

            int posRpg = 0;
            for (int i = 0; i < 5; i++) {
                listRpgAdventure.addGame(allGames.get(i), posRpg++);
            }

            int posPlatform = 0;
            for (int i = 5; i < 10; i++) {
                listPlatform.addGame(allGames.get(i), posPlatform++);
            }

            gameListRepository.saveAll(List.of(listRpgAdventure, listPlatform));
            System.out.println("Game lists (with belongings) inserted into H2 database!");
        }
    }
}
