package selene.frame;

import java.util.Hashtable;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import selene.command.ICommand;
import selene.engine.IGameEngine;

public class SlickInterface extends BasicGame{
	
	private IGameEngine engine;
	
	public SlickInterface(IGameEngine engine, Hashtable<String, ICommand> commands) {
		super("Selene The Game !");
		this.engine = engine;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	

}
