package selene.frame;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopUp extends JFrame{
	
	private JPanel panel;
	
	public PopUp(){
		super("PopUp !");
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		
		this.panel.add(new JLabel("Haha"));
		
		this.setContentPane(this.panel);
		this.pack();
		this.setVisible(true);
		
	}

}
