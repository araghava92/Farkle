package farkle;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {

    private final String player;
    private final String game;
    private final List<Roll> rolls;

    public Player(String player, String game) {
        this.player = player;
        this.game = game;
        this.rolls = new ArrayList<>();
    }

    @Override
    public boolean notifyObserver(Game g) {
        if (this.game == g.getGame()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return player;
    }

    public String getGame() {
        return game;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void addRoll(Roll roll) {
        rolls.add(roll);
    }
}
