package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;




public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;

	public  Gui() {
		super("Fractal Builder");
		this.setSize(600, 600);
		this.add(new MenuPanel(), BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
}
