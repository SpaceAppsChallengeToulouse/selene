package selene.engine;

import java.util.Observer;

public interface IGameEngine {
	public void addObserver(Observer o);
	public void init(int mapSize);
	public Map getMap();
}
