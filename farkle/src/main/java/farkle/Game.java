package farkle;

import java.util.*;

public class Game {

	private String game;
	private Map<String, Player> players;
	
	public Game(String game) {
		this.game = game;
		players = new HashMap<>();
	}

	public void addPlayer(Player p) {
		players.put(p.getName(), p);
	}

	public List<Player> getPlayers() {
		return new ArrayList<>(players.values());
	}

	public Player getPlayer(String playerName) {
		return players.get(playerName);
	}
	
	public String getGame() {
		return game;
	}

}
