package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;
import gui.ColorModelFactory;
/**
 * 
 * @author markk
 *
 */
public class ColorListener implements ActionListener{
	/**
	 * holds color selection value
	 */
	private int _color;
	/**
	 * holds instance of model
	 */
	private Model _model;
	
	/**
	 * Constructor
	 * @param m- instance of model
	 * @param c- color value
	 */
	public ColorListener(Model m, int c){
		_color = c;
		_model = m;
	}
	/**
     * action listener function for colorListener
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetColor(_color);
		_model.updateFactal();
	}

}
