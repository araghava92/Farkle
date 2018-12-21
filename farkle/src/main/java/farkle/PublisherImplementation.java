package farkle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PublisherImplementation implements PublisherInterface {
	
	private List<Observer> subscribers;
	private List<Observer> unregistered_subs;
	
	public PublisherImplementation() {
		subscribers = new ArrayList<>();
		unregistered_subs = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		subscribers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		subscribers.remove(o);
	}

	@Override
	public void notifyObservers(Game g) {
		for (Observer o : subscribers) {
			if (o.notifyObserver(g)) {
				// Use websocket to push plays
			}
		}
	}
}
