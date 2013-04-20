package selene.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * SplashScreen lancé a l'ouverture de notre appli (funny)
 * @author 
 *
 */
public class Splash extends JFrame {
	
	private ImageIcon img;
	private String name;
	
	/**
	 * Constructeur
	 */
	public Splash(String name){
		super();
		this.name = name;
		drawContent();
		
		this.setResizable(false);
		this.setUndecorated(true);
		
		// centre la frame
		setLocationRelativeTo(null);
	}
	
	/**
	 * Remplissage
	 */
	private void drawContent() {
		
		
		img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(name));
		setSize(new Dimension(img.getIconWidth(), img.getIconHeight()));
		JLabel splashLabel = new JLabel(img);
		add(splashLabel, BorderLayout.CENTER);
		
		JProgressBar loadingBar = new JProgressBar(JProgressBar.HORIZONTAL);
		loadingBar.setIndeterminate(true);
		
		add(loadingBar, BorderLayout.SOUTH);
		
		
	}
}

