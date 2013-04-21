package selene.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import selene.entity.IEntity;
import selene.observer.MyObservable;

public class GameEngine implements IGameEngine {
	
	private TiledMap map;
	float mapRenderX=300, mapRenderY=200;
	private List<IEntity> entities;
	private MyObservable obs;
	
	
	public GameEngine(){
		this.obs = new MyObservable();
		entities = new ArrayList<IEntity>();
	}

	@Override
	public void addObserver(Observer o) {
		this.obs.addObserver(o);
	}

	@Override
	public void init(TiledMap map) {
		try {
			this.map = map;
			HashMap<String, Image> loadedImages = new HashMap<String, Image>();
			for(IEntity ent : entities){
				String entsImageName = ent.getImageName();
				
				if(!loadedImages.containsKey(entsImageName))
					loadedImages.put(entsImageName, new Image(entsImageName));

				ent.setImage(loadedImages.get(entsImageName));
			}
		} catch (SlickException e) {
			System.out.println("KILL ME !!!!");
			e.printStackTrace();
		}
		
	}

	@Override
	public TiledMap getMap() {
		return this.map;
	}

	@Override
	public void addEntity(IEntity ent) {
		entities.add(ent);
	}

	@Override
	public void render(Graphics g) {
		map.render((int)mapRenderX, (int)mapRenderY);
		for(IEntity ent : entities){
			ent.render(g, map, mapRenderX, mapRenderY);
		}
	}

	@Override
	public float getRenderX() {
		return mapRenderX;
	}

	@Override
	public void setRenderX(float value) {
		mapRenderX = value;		
	}

	@Override
	public float getRenderY() {
		return mapRenderY;
	}

	@Override
	public void setRenderY(float value) {
		mapRenderY = value;
	}

}
