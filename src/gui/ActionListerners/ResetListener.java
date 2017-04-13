package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;

/**
 * Class which listens to user input for reseting fractal
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao
 */
public class ResetListener implements ActionListener{
	/**
	 * instance of model
	 */
	private Model _model;
	/**
	 * Constructor
	 * @param model- instance of model
	 */
	public ResetListener(Model model){
		_model = model;
	}
	/**
     * action listener function for resetListener
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_model.updateFactal();
		_model.updateFeedback("Selected Zoomed coordinates will appear here");
		
	}

	
}
