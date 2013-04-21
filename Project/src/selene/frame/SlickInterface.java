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
	private static final int COL = 800;
	private static final int LINE = 600;
	private Image image;
	private Image conteneurBouton;
	private TiledMap map;
	private int renderX = 300, renderY = 200;
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
		map.render(renderX, renderY);
		this.conteneurBouton.draw(120, 470, 600, 210);
		this.image.draw(144+0*100, 500, 144+1*100,600, 0, 0*128, 128, 1*128);
		this.image.draw(144+1*100, 500, 144+2*100,600, 0, 1*128, 128, 2*128);
		this.image.draw(144+2*100, 500, 144+3*100,600, 0, 2*128, 128, 3*128);
		this.image.draw(144+3*100, 500, 144+4*100,600, 0, 3*128, 128, 4*128);
		
		//TODO: GET THIS OUT AS tileCoords -> render coords
		drawSubImage(arg1, elementsDeJeu, 
				(float)(bigX=renderX + 1 * map.getTileWidth() / 2 - 1 * map.getTileWidth() / 2),
				(float)(bigY=renderY + 1 * map.getTileHeight() /2 + 1 * map.getTileHeight() /2 - map.getTileHeight()) ,
				64, 64, 0, 0);
		
		drawSubImage(arg1, elementsDeJeu, 
				(float)(bigX=renderX + 10 * map.getTileWidth() / 2 - 7 * map.getTileWidth() / 2),
				(float)(bigY=renderY + 7 * map.getTileHeight() /2 + 10 * map.getTileHeight() /2 - map.getTileHeight()) ,
				64, 64, 0, 0);
		drawSubImage(arg1, elementsDeJeu, 
				(float)(bigX=renderX + 5 * map.getTileWidth() / 2 - 3 * map.getTileWidth() / 2),
				(float)(bigY=renderY + 3 * map.getTileHeight() /2 + 5 * map.getTileHeight() /2 - map.getTileHeight()) ,
				64, 64, 0, 0);
		drawSubImage(arg1, elementsDeJeu, 
				(float)(bigX=renderX + 1 * map.getTileWidth() / 2 - 6 * map.getTileWidth() / 2),
				(float)(bigY=renderY + 6 * map.getTileHeight() /2 + 1 * map.getTileHeight() /2 - map.getTileHeight()) ,
				128, 128, 0, 0);
		drawSubImage(arg1, elementsDeJeu, 
				(float)(bigX=renderX + 12 * map.getTileWidth() / 2 - 4 * map.getTileWidth() / 2),
				(float)(bigY=renderY + 4 * map.getTileHeight() /2 + 12 * map.getTileHeight() /2 - map.getTileHeight()) ,
				256, 256, 0, 0);
		//END TODO.
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
		if( input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(!mouseDown){
				mouseDown = true;
				mouseX = input.getAbsoluteMouseX();
				mouseY = input.getAbsoluteMouseY();
				if(mapI[mouseY][mouseX] == 1){
					PopUp p = new PopUp();
				}
				System.out.println(this.mapI[mouseY][mouseX]);
				calculateTileXY(mouseX, mouseY);
//				elementX = tileX;
//				elementY = tileY;
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
	
	public void printMap(){
		for(int i=0; i<this.mapI.length; i++) {
			System.out.println("");
			for(int j=0; j<this.mapI.length; j++){
				System.out.print(this.mapI[i][j]);
			}
		}
	}
	
	

}
