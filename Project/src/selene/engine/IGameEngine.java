package selene.engine;

import java.util.Observer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;

import selene.entity.IEntity;

public interface IGameEngine {
	public void addObserver(Observer o);
	public void init(TiledMap map);
	public TiledMap getMap();
	public void addEntity(IEntity ent);
	public void render(Graphics g);
	
	float getRenderX();
	void setRenderX(float value);
	float getRenderY();
	void setRenderY(float value);
	
	public void setAdding(IEntity ent);
	public void placeEntity();
	public void setMouseX(int mouseX);
	public void setMouseY(int mouseY);
}
