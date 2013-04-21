package selene.frame;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Help extends JFrame implements ActionListener{
	
	private JPanel panel;
	
	public Help(){
		super("Fusee !");
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel,BoxLayout.PAGE_AXIS) );
		this.panel.add(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("data/fusee.jpg"))), BorderLayout.NORTH);
		String sr = "Une fusée en astronautique est un véhicule qui se déplace dans l'espace grâce à un moteur-fusée en emportant \n";
		String sr1 = "à la fois le combustible et le comburant nécessaires à son fonctionnement. Une fusée comprend plusieurs étages \n";
		String sr2 ="pour maximiser sa capacité d'emport. Les plus grosses fusées construites, comme Saturn V, permettent de placer \n";
		String sr3 ="jusqu'à 150 tonnes en orbite basse. \n";
		String sr4 ="La science des fusées a été théorisée par le Russe Constantin Tsiolkovski à la fin du XIXe siècle \n";
		String sr5 ="et mise en pratique peu avant la Seconde Guerre mondiale par les chercheurs allemands à des fins militaires. \n";
		String sr6 ="À compter de la fin des années 1950, les fusées ont été utilisées pour mettre en orbite des satellites à des fins";
		String sr7 =" commerciales ou de recherche, envoyer des sondes spatiales vers les autres planètes du système solaire \n";
		String sr8 =" et envoyer des hommes dans l'espace. La technologie des fusées n'évolue pratiquement plus depuis la fin des années 1960.";
		this.panel.add(new JLabel(sr));
		this.panel.add(new JLabel(sr1));
		this.panel.add(new JLabel(sr2));
		this.panel.add(new JLabel(sr3));
		this.panel.add(new JLabel(sr4));
		this.panel.add(new JLabel(sr5));
		this.panel.add(new JLabel(sr6));
		this.panel.add(new JLabel(sr7));
		this.panel.add(new JLabel(sr8));
		
  
		
		JButton cool = new JButton("Cool, merci !");
		cool.addActionListener(this);
		this.panel.add(cool, BorderLayout.SOUTH);
		
		this.setContentPane(this.panel);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
