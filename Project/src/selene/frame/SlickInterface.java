package selene.frame;

import java.util.Hashtable;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import selene.command.ICommand;
import selene.engine.IGameEngine;

public class SlickInterface extends BasicGame{
	
	private IGameEngine engine;
	private Image image;
	private TiledMap map;
	private int renderX = 300, renderY = 200;
	
	public SlickInterface(IGameEngine engine, Hashtable<String, ICommand> commands) {
		super("Selene The Game !");
		this.engine = engine;
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		map.render(renderX, renderY);
		this.image.draw(1, 1, 0.5f);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		try {
			this.image = new Image("data/logo.png");
			this.map = new TiledMap("test_data/map1.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	

}
