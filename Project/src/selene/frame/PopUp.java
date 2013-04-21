package selene.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame implements ActionListener{
	
	private JPanel panel;
	
	public PopUp(){
		super("PopUp !");
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		
		this.panel.add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("gui_data/fusee.png"))));
		
		this.panel.add(new JLabel("Energie: 97%"));
		this.panel.add(new JLabel("Etat: Bon etat"));
		this.panel.add(new JLabel("Remplissage: 30%"));
		this.panel.add(new JLabel("..."));
		this.panel.add(new JButton("Ajouter..."));
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
