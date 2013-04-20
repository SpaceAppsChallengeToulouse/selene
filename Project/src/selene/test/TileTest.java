package selene.test;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class TileTest {

	public class IsometricTestGame extends BasicGame {

		private TiledMap map;
		private int renderX = 300, renderY = 200;
		int tileX = 0,tileY = 0;
		double bigX=-1, bigY=-1;
		private int mouseX, mouseY;
		private boolean mouseDown = false;

		public IsometricTestGame(String title) {
			super(title);
		}

		@Override
		public void render(GameContainer arg0, Graphics arg1)
				throws SlickException {
			map.render(renderX, renderY);
			arg0.getGraphics().drawString("["+tileX+","+tileY+"]", 10, 50);
			arg0.getGraphics().drawString("["+bigX+","+bigY+"]", 10, 70);
			arg0.getGraphics().drawString("["+mouseX+","+mouseY+"]", 10, 90);
			
		}

		@Override
		public void init(GameContainer arg0) throws SlickException {
			map = new TiledMap("test_data/map1.tmx");
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
