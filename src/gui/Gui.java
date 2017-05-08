package gui;

import java.awt.BorderLayout;
import javax.swing.*;
import edu.buffalo.cse116.Model;


/**
 * Class which sets up gui
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */
public class Gui extends JFrame {
	/** I have no idea what this is, eclipse add it
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  reference to model passed by model itself
	 */
    private Model _model;
    /**
	 *  reference to dropdown menu
	 */
    private DropDownMenu _menubar;
    
	/** Constructor
	 * 
	 * @param model reference to model
	 */
	public  Gui(Model model) {
		super("Fractal Builder");
		_model = model;
		_menubar = new DropDownMenu(_model);
		this.setSize(1000,1000);
	    this.add(_menubar, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * updates zoom coordinates and dimensions to display
	 * @param string- zoom coordinates and dimensions
	 */
	public void updateFeedback(String string){
		_menubar.updateFeedback(string);
	}
	
	

	
	
}
