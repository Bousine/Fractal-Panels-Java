package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;
import gui.ColorModelFactory;

public class ColorListener implements ActionListener{
	
	/**
	 * Holds the current color
	 */
	private int _color;
	
	/**
	 * Reference to Model
	 */
	private Model _model;
	
	/** constructor
	 *@param model is passed by dropdownmenu and holds reference to model
	 *@param c- color passed by dropdownmenu
	 */
	public ColorListener(Model m, int c){
		_color = c;
		_model = m;
	}
	
	/**
	 * ActionListener for changing the color
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetColor(_color);
	}

}
