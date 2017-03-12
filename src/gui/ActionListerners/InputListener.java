package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;

import code.*;

public class InputListener implements ActionListener{
	
	private JFormattedTextField _t;
	private BurningShipSet _bs; 
	
	public InputListener(JFormattedTextField t, BurningShipSet b){
		_t = t;
		_bs = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = _t.getText();
		int d = Integer.parseInt(text);
		_bs.setEscapeDistance(d);
	}
	

}
