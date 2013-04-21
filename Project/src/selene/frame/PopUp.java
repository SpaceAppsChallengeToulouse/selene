package selene.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import selene.engine.IGameEngine;
import selene.entity.Building;
import selene.entity.IEntity;

public class PopUp extends JFrame implements ActionListener{
	
	private JPanel panel;
	
	static class RocketAdder implements ActionListener{
		
		IGameEngine engine;
		PopUp popup;
		
		public RocketAdder(IGameEngine engine, PopUp popUp){
			this.engine = engine;
			popup = popUp;
		}

		static int counter = 1;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Image elements = null;
			try {
				elements = new Image("gui_data/elements.png");
			} catch (SlickException e) {
				System.out.println("KILLLLL MEEEEEEE !!!! (brainz!)");
				e.printStackTrace();
			}
			IEntity newFusee = new Building("Fusee-"+counter++, 0, 0, 0.0, new ArrayList<Double>(), new ArrayList<Double>(), 0.0, -1.0, 1, 1);
			newFusee.setupRender(new String(), 0, 0, 64, 64);
			newFusee.setImage(elements);
			engine.setAdding(newFusee);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(popup, WindowEvent.WINDOW_CLOSING));
		}
		
	};
	
	RocketAdder rocketAdder;
	
	public PopUp(IGameEngine engine){
		super("PopUp !");
		rocketAdder = new RocketAdder(engine, this);
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		
		this.panel.add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("gui_data/fusee.png"))));
		
		this.panel.add(new JLabel("Energie: 97%"));
		this.panel.add(new JLabel("Etat: Bon etat"));
		this.panel.add(new JLabel("Remplissage: 30%"));
		this.panel.add(new JLabel("..."));
		JButton ajouter = new JButton("Ajouter...");
		ajouter.addActionListener(rocketAdder);
		this.panel.add(ajouter);
		this.panel.add(new JButton("Supprimer..."));
		JButton help = new JButton("Help");
		help.addActionListener(this);
		this.panel.add(help);
		
		this.setContentPane(this.panel);
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Help h = new Help();
	}

}
