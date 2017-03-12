package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Model;
import gui.ColorModelFactory;

public class ColorListener implements ActionListener{
	
	private int _color;
	private Model _model;
	
	
	public ColorListener(int c){
		_color = c;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		_model.SetColor(_color);
	}

}
