package selene.launch;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import selene.command.ICommand;
import selene.engine.GameEngine;
import selene.engine.IGameEngine;
import selene.entity.Building;
import selene.entity.IEntity;
import selene.entity.Robot;
import selene.frame.SlickInterface;
import selene.frame.Splash;
import selene.test.TileTest;
import selene.test.TileTest.IsometricTestGame;

public class Launcher {
	
	public static void main(String[] args) {
		Hashtable<String,ICommand> cmd = new Hashtable<String,ICommand>();
		Splash s = new Splash("data/logo1.png");
		s.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setVisible(false);
		String sr = " ''Bonjour, Houston. Nous avons atterri.'' \n \n" +
				"Cette simple phrase, en s'affichant sur vos �crans, a d�clench� un tonnerre d'acclamations.\n" +
				"Depuis presque six jours, vous suivez le parcours de la navette BIFROST charg�e \n"+
				"d'acheminer votre pr�cieuse cargaison vers la Lune. Vous y avez entass� tout ce que vous \n"+
				"avez pu ;  un scanner et une imprimante 3D, un bulldozer et une pelleteuse, un four � \n"+
				"induction et des panneaux solaires, tout ce dont vous pourriez avoir besoin pour faire surgir  \n"+
				"des monotones �tendues lunaires une florissante industrie. Le sas s�ouvre sur l�ext�rieur, \n"+
				"lib�rant le passage aux rares occupants de la navette ; DANEEL, l'op�rateur, HUGIN et \n"+
				"MUNIN, les explorateurs,  DOC, le r�parateur, et AM, STRAM, GRAM, les trois ouvriers. \n \n"+
				"Sept robots, du mat�riel, et un monde � exploiter. ";
		JOptionPane.showMessageDialog(new JFrame(), sr);
		IGameEngine engine = new GameEngine();
		IEntity fusee = new Building("Fusee", 10, 10, 0.0, new ArrayList<Double>(), new ArrayList<Double>(), 0.0, 0.0, 1, 1),
				comm = new Building("comm tower", 10, 9, 0.0, new ArrayList<Double>(), new ArrayList<Double>(), 0.0, 0.0, 1, 1),
				robot = new Robot("Truck", 8, 10, 0, new ArrayList<Double>(), new ArrayList<Double>(), 10, 0.0, 1.0, 1.1, 500, 1.0, 1.0, new String(), new ArrayList<String>(), new ArrayList<Double>()),
				robot2 = new Robot("Truck2", 12, 11, 0, new ArrayList<Double>(), new ArrayList<Double>(), 10, 0.0, 1.0, 1.1, 500, 1.0, 1.0, new String(), new ArrayList<String>(), new ArrayList<Double>()),
				solarPanel = new Building("Solar", 8,12,0.0, new ArrayList<Double>(), new ArrayList<Double>(), 0.0, 0.0, 1, 1);
		fusee.setupRender("gui_data/elements.png", 0, 0, 64, 64);
		robot.setupRender("gui_data/elements.png", 0, 64,64, 64);
		robot2.setupRender("gui_data/elements.png", 0, 64,64, 64);
		comm.setupRender("gui_data/elements.png", 0, 128,64, 64);
		solarPanel.setupRender("gui_data/elements.png", 0, 192, 64, 64);
		
		engine.addEntity(fusee);
		engine.addEntity(robot);
		engine.addEntity(robot2);
		engine.addEntity(comm);
		engine.addEntity(solarPanel);
		
		SlickInterface slick = new SlickInterface(engine, cmd);
		AppGameContainer app;

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
