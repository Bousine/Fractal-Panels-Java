package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;


// This listener will just reset the factual back to the original and won't do anything until we actually implement the zoom method 
public class ResetListener implements ActionListener{
	private Model _model;

	public ResetListener(Model model){
		_model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_model.updateFactal();
		_model.updateFeedback("Selected Zoomed coordinates will appear here");
		
	}

	
}
