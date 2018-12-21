package farkle;

public interface PublisherInterface {
	
	public void registerObserver(Observer o);
	
	public void unregisterObserver(Observer o);
	
	public void notifyObservers(Game g);
}
