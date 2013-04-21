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
	float mouseX, mouseY;
	private List<IEntity> entities;
	private MyObservable obs;
	IEntity entInAddition;
	
	static class XY{
		public int x,y;
	}
	
	private XY calculateTileXY(int mouseX, int mouseY){
		XY result = new XY();
		double tempX = ((double)mouseX - (double)mapRenderX) / (double)map.getTileWidth() -0.5;
		double tempY = ((double)mouseY - (double)mapRenderY) / (double)map.getTileHeight();
		result.x = (int) ( tempX + tempY);
		result.y = (int) (-tempX + tempY);
		return result;
	}
	
	
	public GameEngine(){
		this.obs = new MyObservable();
		entities = new ArrayList<IEntity>();
		entInAddition = null;
	}

	@Override
	public void addObserver(Observer o) {
		this.obs.addObserver(o);
	}

	static HashMap<String, Image> loadedImages = new HashMap<String, Image>();
	@Override
	public void init(TiledMap map) {
		try {
			this.map = map;
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
		//draw back of map
		map.render((int)mapRenderX, (int)mapRenderY);
		//draw entities on map
		for(IEntity ent : entities){
			ent.render(g, map, mapRenderX, mapRenderY);
		}
		//draw currently placing building map.
		if(entInAddition!=null){
			XY coords = calculateTileXY((int)mouseX, (int)mouseY);
			entInAddition.setPositionX(coords.x);
			entInAddition.setPositionY(coords.y);
			entInAddition.render(g, map, mapRenderX, mapRenderY);
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

	public void setAdding(IEntity ent) {
		entInAddition=ent;
		XY coords = calculateTileXY((int)mouseX, (int)mouseY);
		entInAddition.setPositionX(coords.x);
		entInAddition.setPositionY(coords.y);
	}
	
	public void placeEntity(){
		if(entInAddition != null){
			entities.add(entInAddition);
			//TODO: collision check with other buildings if entInAddition is a building
			entInAddition = null;
		}
	}

	@Override
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	@Override
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

}
