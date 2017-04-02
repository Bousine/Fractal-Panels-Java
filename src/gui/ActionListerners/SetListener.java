package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;

public class SetListener implements ActionListener{
	
	private int _set;
	private Model _model;
	
	
	public SetListener(Model m, int s){
		_set = s;
		
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetFractal(_set);
		
	}

}
