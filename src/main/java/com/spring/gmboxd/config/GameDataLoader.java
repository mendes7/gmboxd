package com.spring.gmboxd.config;

import com.spring.gmboxd.entities.Game;
import com.spring.gmboxd.repositories.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GameDataLoader implements CommandLineRunner {

    private final GameRepository gameRepository;

    public GameDataLoader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.count() == 0) {
            List<Game> games = List.of(
                    new Game(null, "Mass Effect Trilogy", 2012, "RPG, Shooter", "XBox, Playstation, PC", 4.8,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
                            "Epic sci-fi RPG adventure.", "Experience the full Mass Effect saga with all three games combined."),
                    new Game(null, "Red Dead Redemption 2", 2018, "RPG, Adventure", "XBox, Playstation, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png",
                            "Wild west open world RPG.", "Embark on an epic journey in the American frontier."),
                    new Game(null, "The Witcher 3: Wild Hunt", 2014, "RPG, Adventure", "XBox, Playstation, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png",
                            "Fantasy open world RPG.", "Hunt monsters and explore a vast fantasy world as Geralt of Rivia."),
                    new Game(null, "Sekiro: Shadows Die Twice", 2019, "RPG, Adventure", "XBox, Playstation, PC", 3.8,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png",
                            "Challenging action RPG.", "Master sword combat and stealth in feudal Japan."),
                    new Game(null, "Ghost of Tsushima", 2012, "RPG, Adventure", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png",
                            "Open world samurai adventure.", "Fight against invaders and protect Tsushima Island."),
                    new Game(null, "Super Mario World", 1990, "Platform", "Super NES, PC", 4.7,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png",
                            "Classic platformer.", "Guide Mario through levels to save Princess Peach."),
                    new Game(null, "Hollow Knight", 2017, "Platform", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png",
                            "Metroidvania platformer.", "Explore a vast underground world full of secrets."),
                    new Game(null, "Ori and the Blind Forest", 2015, "Platform", "XBox, Playstation, PC", 4.0,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png",
                            "Beautiful platform adventure.", "Follow Ori on a heartfelt journey through a magical forest."),
                    new Game(null, "Cuphead", 2017, "Platform", "XBox, Playstation, PC", 4.6,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png",
                            "Challenging run-and-gun game.", "Fight bosses with unique hand-drawn animations."),
                    new Game(null, "Sonic CD", 1993, "Platform", "Sega CD, PC", 4.0,
                            "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png",
                            "Classic Sonic platformer.", "Speed through levels and collect rings as Sonic.")
            );

            gameRepository.saveAll(games);
            System.out.println("Games inserted into H2 database!");
        }
    }
}
