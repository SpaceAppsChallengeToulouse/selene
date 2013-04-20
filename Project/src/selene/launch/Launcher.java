package selene.launch;

import java.util.Hashtable;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import selene.command.ICommand;
import selene.engine.GameEngine;
import selene.engine.IGameEngine;
import selene.frame.SlickInterface;
import selene.test.TileTest;
import selene.test.TileTest.IsometricTestGame;

public class Launcher {
	
	public static void main(String[] args) {
		Hashtable<String,ICommand> cmd = new Hashtable<String,ICommand>();
		IGameEngine engine = new GameEngine();
		SlickInterface slick = new SlickInterface(engine, cmd);
		AppGameContainer app;
		//TileTest tiletest = new TileTest();

		try {
			app = new AppGameContainer(slick);
			app.setDisplayMode(800, 600, false);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
