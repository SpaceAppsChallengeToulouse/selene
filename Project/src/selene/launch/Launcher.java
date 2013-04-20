package selene.launch;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import selene.command.ICommand;
import selene.engine.GameEngine;
import selene.engine.IGameEngine;
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
				"Cette simple phrase, en s'affichant sur vos écrans, a déclenché un tonnerre d'acclamations.\n" +
				"Depuis presque six jours, vous suivez le parcours de la navette BIFROST chargée \n"+
				"d'acheminer votre précieuse cargaison vers la Lune. Vous y avez entassé tout ce que vous \n"+
				"avez pu ;  un scanner et une imprimante 3D, un bulldozer et une pelleteuse, un four à \n"+
				"induction et des panneaux solaires, tout ce dont vous pourriez avoir besoin pour faire surgir  \n"+
				"des monotones étendues lunaires une florissante industrie. Le sas s’ouvre sur l’extérieur, \n"+
				"libérant le passage aux rares occupants de la navette ; DANEEL, l'opérateur, HUGIN et \n"+
				"MUNIN, les explorateurs,  DOC, le réparateur, et AM, STRAM, GRAM, les trois ouvriers. \n \n"+
				"Sept robots, du matériel, et un monde à exploiter. ";
		JOptionPane.showMessageDialog(new JFrame(), sr);
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
