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
		String sr = "Une fus�e en astronautique est un v�hicule qui se d�place dans l'espace gr�ce � un moteur-fus�e en emportant \n";
		String sr1 = "� la fois le combustible et le comburant n�cessaires � son fonctionnement. Une fus�e comprend plusieurs �tages \n";
		String sr2 ="pour maximiser sa capacit� d'emport. Les plus grosses fus�es construites, comme Saturn V, permettent de placer \n";
		String sr3 ="jusqu'� 150 tonnes en orbite basse. \n";
		String sr4 ="La science des fus�es a �t� th�oris�e par le Russe Constantin Tsiolkovski � la fin du XIXe si�cle \n";
		String sr5 ="et mise en pratique peu avant la Seconde Guerre mondiale par les chercheurs allemands � des fins militaires. \n";
		String sr6 ="� compter de la fin des ann�es 1950, les fus�es ont �t� utilis�es pour mettre en orbite des satellites � des fins";
		String sr7 =" commerciales ou de recherche, envoyer des sondes spatiales vers les autres plan�tes du syst�me solaire \n";
		String sr8 =" et envoyer des hommes dans l'espace. La technologie des fus�es n'�volue pratiquement plus depuis la fin des ann�es 1960.";
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
