package selene.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import selene.engine.IGameEngine;

public class Frame extends JFrame{
	
	private JPanel panel;
	private JPanel center;
	private IGameEngine engine;
	
	public Frame(IGameEngine engine) {
		super("Test");
		this.engine = engine;
		this.setSize(600, 400);
		
		////////////////////////////////PANELS INSTANCE//////////////////////////
		this.panel =  new JPanel();
		this.center = new JPanel();
		
		////////////////////////////////PANELS LAYOUT///////////////////////////
		this.panel.setLayout(new BorderLayout());
		this.center.setLayout(new GridLayout(this.engine.getMap().getHeight(), this.engine.getMap().getWidth()));
		
		////////////////////////////////PANELS ADD//////////////////////////////
		
	}

}
