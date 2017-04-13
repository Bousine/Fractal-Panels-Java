package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;
/**
 * Class which listens to user input for fractal choice
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao
 */
public class SetListener implements ActionListener{
	/**
	 * holds value for fractal choice
	 */
	private int _set;
	/**
	 * instance of model
	 */
	private Model _model;
	
	/**
	 * Constructor
	 * @param m- instance of model
	 * @param s- value of fractal choice
	 */
	public SetListener(Model m, int s){
		_set = s;
		
		_model = m;
	}
	/**
     * action listener function for setListener
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetFractal(_set);
		
	}

}
