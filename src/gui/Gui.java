package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import edu.buffalo.cse116.Model;
import edu.buffalo.fractal.FractalPanel;


public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
    private Model _model;
    private FractalPanel _f = new FractalPanel();
	
	public  Gui(Model model) {
		super("Fractal Builder");
		_model = model;
		this.setSize(600, 600);
	    this.add(new DropDownMenu(_model), BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(_f);
	}
	
	

	
	
}
