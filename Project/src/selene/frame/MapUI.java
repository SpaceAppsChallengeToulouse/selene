package selene.frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import selene.engine.IGameEngine;

public class MapUI extends JComponent implements Observer{
	
	private static final int TAILLE_PIXELS = 20;
	private Image sol;
	private IGameEngine engine;
	

	public MapUI(IGameEngine engine) {
		this.engine = engine;
		this.setPreferredSize(new Dimension(this.engine.getMap().getHeight()*TAILLE_PIXELS,this.engine.getMap().getWidth()*TAILLE_PIXELS));
		this.sol = getToolkit().getImage("data/sol.png");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
