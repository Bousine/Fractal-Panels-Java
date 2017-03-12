package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;

import code.*;

public class InputListener implements ActionListener{
	
	private JFormattedTextField _t;
	private BurningShipSet _bs; 
	private JuliaSet _js;
	private MandelbrotSet _mandel;
	private MultibrotSet _multi;
	
	public InputListener(JFormattedTextField t, BurningShipSet b, JuliaSet j, MandelbrotSet mandel, MultibrotSet multi){
		_t = t;
		_bs = b;
		_js = j;
		_mandel = mandel;
		_multi = multi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = _t.getText();
		int d = Integer.parseInt(text);
//		_bs.setEscapeDistance(d);
	}
	

}
