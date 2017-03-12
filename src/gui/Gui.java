package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import edu.buffalo.cse116.Model;




public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
    private Model _model;
	
	public  Gui(Model model) {
		super("Fractal Builder");
		_model = model;
		this.setSize(600, 600);
		this.add(new MenuPanel(_model), BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
}
