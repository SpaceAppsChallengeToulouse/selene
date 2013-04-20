package selene.frame;

import java.util.Hashtable;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import selene.command.ICommand;
import selene.engine.IGameEngine;

public class SlickInterface extends BasicGame{
	
	private IGameEngine engine;
	private Image image;
	private Image conteneurBouton;
	private TiledMap map;
	private int renderX = 300, renderY = 200;
	private boolean mouseDown = false;
	private int mouseX;
	private int mouseY;
	
	public SlickInterface(IGameEngine engine, Hashtable<String, ICommand> commands) {
		super("Selene The Game !");
		this.engine = engine;
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		map.render(renderX, renderY);
		this.conteneurBouton.draw(120, 470, 600, 210);
		this.image.draw(144+0*100, 500, 144+1*100,600, 0, 0*128, 128, 1*128);
		this.image.draw(144+1*100, 500, 144+2*100,600, 0, 1*128, 128, 2*128);
		this.image.draw(144+2*100, 500, 144+3*100,600, 0, 2*128, 128, 3*128);
		this.image.draw(144+3*100, 500, 144+4*100,600, 0, 3*128, 128, 4*128);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		try {
			this.image = new Image("gui_data/Boutons.png");
			this.conteneurBouton = new Image("gui_data/conteneur_boutons.png");
			this.map = new TiledMap("test_data/map1.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Input input = arg0.getInput();
		if( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(!mouseDown){
				mouseDown = true;
				mouseX = input.getAbsoluteMouseX();
				mouseY = input.getAbsoluteMouseY();
				//calculateTileXY(mouseX, mouseY);
			}
			renderX -= mouseX - input.getAbsoluteMouseX();
			renderY -= mouseY - input.getAbsoluteMouseY();
			mouseX = input.getAbsoluteMouseX();
			mouseY = input.getAbsoluteMouseY();
		} else {
			if(mouseDown){
				mouseDown = false;
			}
		}
		
	}
	
	

}
