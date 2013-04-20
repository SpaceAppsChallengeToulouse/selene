package selene.engine;

import java.util.List;
import java.util.Observer;

import selene.entity.IEntity;
import selene.observer.MyObservable;

public class GameEngine implements IGameEngine {
	
	private Map map;
	private List<IEntity> entities;
	private MyObservable obs;
	
	public GameEngine(){
		this.obs = new MyObservable();
		
	}

	@Override
	public void addObserver(Observer o) {
		this.obs.addObserver(o);
	}
}
