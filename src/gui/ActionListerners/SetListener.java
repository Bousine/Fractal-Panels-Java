package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;

public class SetListener implements ActionListener{
	
	/**
	 * holds the current Fractal Selection
	 */
	private int _set;
	
	/**
	 * holds reference to model
	 */
	private Model _model;
	
	/**
	 * Constructor for SetListener
	 * @param m- reference to Model
	 * @param s- fractal selection passed by dropdown menu
	 */
	public SetListener(Model m, int s){
		_set = s;
		
		_model = m;
	}
	
	/**
	 * ActionListener for Fractal Selection
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetFractal(_set);
		
	}

}
