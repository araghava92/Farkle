package farkle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

import java.util.*;

@RestController
public class GameController {

    private PublisherImplementation pub;
    private Map<String, Game> games;

    @PostConstruct
    public void initialize() {
        pub = new PublisherImplementation();
        games = new HashMap<>();
    }

    @RequestMapping("/joinGame")
    public Game joinGame(@RequestParam(value="name", required=false, defaultValue="name1") String name,
                             @RequestParam(value="game", required=false, defaultValue="game1") String gameName) {
        Player p = new Player(name, gameName);
        if (pub == null) {
            throw new RuntimeException("Server issue: No publisher!");
        }

        pub.registerObserver(p);

        Game game = games.get(gameName);
        if(game == null) {
            game = new Game(gameName);
            games.put(gameName, game);
        }
        game.addPlayer(p);

        return game;
    }


    @RequestMapping("/playedTurn")
    public Game playedTurn(@RequestParam(value="player", required=false, defaultValue="name1") String playerName,
                             @RequestParam(value="game", required=false, defaultValue="game1") String gameName,
                             @RequestParam(value="roll", required=false, defaultValue="1,1,1,1,1,1") String rollAsString) {
        Game game = games.get(gameName);

        if (game == null) {
            game = joinGame(playerName, gameName);
        }

        Player player = game.getPlayer(playerName);
        if (player == null) {
            throw new RuntimeException("Player doesn't exist");
        }
        String[] rollAsStringArray = rollAsString.split(",");
        int[] roll = new int[6];
        for (int i = 0; i < roll.length; i++) {
            roll[i] = Integer.parseInt(rollAsStringArray[i]);
        }

        player.addRoll(new Roll(roll));

        pub.notifyObservers(game);

        return game;
    }

    @RequestMapping("/")
    public String game() {
        return "Farkle";
    }
}
