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
import selene.engine.GameEngine;
import selene.engine.IGameEngine;

public class SlickInterface extends BasicGame{
	
	private IGameEngine engine;
	private static final int COL = 800;
	private static final int LINE = 600;
	private Image image;
	private Image conteneurBouton;
	private TiledMap map;
	private int renderX, renderY;
	private boolean mouseDown = false;
	private int mouseX;
	private int mouseY;
	private int tileX = 0,tileY = 0;
	private double bigX=-1, bigY=-1;
	private int elementX;
	private int elementY;
	private Image elementsDeJeu;
	private int[][] mapI;
	
	public SlickInterface(IGameEngine engine, Hashtable<String, ICommand> commands) {
		super("Selene The Game !");
		this.engine = engine;
		this.mapI = new int[LINE][COL];
		for(int i=0; i<LINE; i++) {
			for(int j=0; j<COL; j++) {
				this.mapI[i][j] = 0;
			}
		}
		for(int i=500; i<LINE; i++) {
			for(int j=150; j<240; j++) {
				this.mapI[i][j] = 1;
			}
		}
		// TODO Auto-generated constructor stub
	}


	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		engine.render(arg1);
		this.conteneurBouton.draw(0, 450, 800, 700, 0,0,800,210);
		for(int i = 0 ; i < 4 ; ++i){
			this.image.draw(144+(i)*128, 480, 144+(i+1)*128, 608, 0, (i)*128, 128, (i+1)*128);
		}
	}
	
	public void drawSubImage(Graphics g, Image img, float x, float y, float width, float height, float srcX, float srcY){
		g.drawImage(img, x, y, x+width, y+height, srcX, srcY, srcX+width, srcY+height);
	}
	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		try {
			this.image = new Image("gui_data/Boutons.png");
			this.conteneurBouton = new Image("gui_data/conteneur_boutons.png");
			elementsDeJeu = new Image("gui_data/elements.png");
			this.map = new TiledMap("test_data/map1.tmx");
			this.engine.init(this.map);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void calculateTileXY(int mouseX, int mouseY){
		double tempX = bigX = ((double)mouseX - (double)renderX) / (double)map.getTileWidth() -0.5;
		double tempY = bigY = ((double)mouseY - (double)renderY) / (double)map.getTileHeight();
		tileX = (int) ( tempX + tempY);
		tileY = (int) (-tempX + tempY);
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Input input = arg0.getInput();
		engine.setMouseX(input.getAbsoluteMouseX());
		engine.setMouseY(input.getAbsoluteMouseY());
		if( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(!mouseDown){
				mouseDown = true;
				mouseX = input.getAbsoluteMouseX();
				mouseY = input.getAbsoluteMouseY();
				if(mapI[mouseY][mouseX] == 1){
					@SuppressWarnings("unused")
					PopUp p = new PopUp(engine);
				} else {
					engine.placeEntity();
				}
				System.out.println(this.mapI[mouseY][mouseX]);
				calculateTileXY(mouseX, mouseY);
			}
			renderX -= mouseX - input.getAbsoluteMouseX();
			renderY -= mouseY - input.getAbsoluteMouseY();
			mouseX = input.getAbsoluteMouseX();
			mouseY = input.getAbsoluteMouseY();
			engine.setRenderX(renderX);
			engine.setRenderY(renderY);
		} else {
			if(mouseDown){
				mouseDown = false;
			}
		}
	}
	
	public void printMap(){
		for(int i=0; i<this.mapI.length; i++) {
			System.out.println("");
			for(int j=0; j<this.mapI.length; j++){
				System.out.print(this.mapI[i][j]);
			}
		}
	}
	
	

}
