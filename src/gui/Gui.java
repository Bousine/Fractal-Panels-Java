package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import edu.buffalo.cse116.Model;
import edu.buffalo.fractal.FractalPanel;


public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
    private Model _model;
	
	public  Gui(Model model) {
		super("Fractal Builder");
		FractalPanel f = new FractalPanel();
		_model = model;
		this.setSize(600, 600);
	    this.add(new DropDownMeun(_model), BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(f);
	}

	
	
}
