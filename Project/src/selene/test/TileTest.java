package selene.test;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.tiled.TiledMap;

public class TileTest {

	public class IsometricTestGame extends BasicGame {

		private TiledMap map;
		private int renderX = 300, renderY = 200;
		int tileX = 0,tileY = 0;
		double bigX=-1, bigY=-1;
		private int mouseX, mouseY;
		private boolean mouseDown = false;
		Image elementsDeJeu;
		int elementX=0, elementY=0;
		boolean keyDown = false;

		public IsometricTestGame(String title) {
			super(title);
		}
		
		void drawSubImage(Graphics g, Image img, float x, float y, float width, float height, float srcX, float srcY){
			g.drawImage(img, x, y, x+width, y+height, srcX, srcY, srcX+width, srcY+height);
		}

		@Override
		public void render(GameContainer arg0, Graphics arg1)
				throws SlickException {
			map.render(renderX, renderY);
			arg0.getGraphics().drawString("["+tileX+","+tileY+"]", 10, 50);
			//TODO: GET THIS OUT AS tileCoords -> render coords
			drawSubImage(arg1, elementsDeJeu, 
					(float)(bigX=renderX + elementX * map.getTileWidth() / 2 - elementY * map.getTileWidth() / 2),
					(float)(bigY=renderY + elementY * map.getTileHeight() /2 + elementX * map.getTileHeight() /2 - map.getTileHeight()) ,
					64, 64, 0, 0);
			//END TODO.
			arg0.getGraphics().drawString("["+bigX+","+bigY+"]", 10, 70);
			arg0.getGraphics().drawString("["+mouseX+","+mouseY+"]", 10, 90);
		}

		@Override
		public void init(GameContainer arg0) throws SlickException {
			map = new TiledMap("test_data/map1.tmx");
			elementsDeJeu = new Image("gui_data/elements.png");
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
					calculateTileXY(mouseX, mouseY);
					elementX = tileX;
					elementY = tileY;
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
			if(keyDown){
				if(input.isKeyDown(Input.KEY_NUMPAD8)){
					elementX -= 1;
					elementY -= 1;
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD2)){
					elementX += 1;
					elementY += 1;
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD4)){
					elementX += 1;
					elementY -= 1;
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD6)){
					elementX -= 1;
					elementY += 1;
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD7)){
					elementX -= 1; 
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD3)){
					elementX += 1; 
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD9)){
					elementY -= 1; 
					keyDown = true;
				} else if(input.isKeyDown(Input.KEY_NUMPAD1)){
					elementY += 1; 
					keyDown = true;
				}
			} else {
				if(!input.isKeyDown(Input.KEY_NUMPAD1)&&
						!input.isKeyDown(Input.KEY_NUMPAD2)&&
						!input.isKeyDown(Input.KEY_NUMPAD3)&&
						!input.isKeyDown(Input.KEY_NUMPAD4)&&
						!input.isKeyDown(Input.KEY_NUMPAD5)&&
						!input.isKeyDown(Input.KEY_NUMPAD6)&&
						!input.isKeyDown(Input.KEY_NUMPAD7)&&
						!input.isKeyDown(Input.KEY_NUMPAD8)&&
						!input.isKeyDown(Input.KEY_NUMPAD9)
						){
					keyDown = false;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppGameContainer app;
		TileTest tiletest = new TileTest();

		try {
			app = new AppGameContainer(tiletest.new IsometricTestGame("Test !"));
			app.setDisplayMode(800, 600, false);
			app.setShowFPS(true);
			app.start();
		} catch (SlickException e) {
			System.out.println("THIS IS A TEEEEST !");
			e.printStackTrace();
		}

	}

}
