package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.buffalo.cse116.Model;
import gui.MenuPanel;

public class InputListener implements ActionListener{
	private Model _model;
	private MenuPanel _panel;
	public InputListener(Model model, MenuPanel panel){
		_model = model;
		_panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException{
		double inputValue;
		try{
			inputValue = Double.parseDouble(_panel.getTextField());
			if(!(inputValue>0)){
				throw new NumberFormatException();
			}
			_model.SetInput(inputValue);
			_panel.TextFieldReset();
		}
		catch(NumberFormatException d){
			_panel.TextFieldReset();
			JOptionPane.showMessageDialog(null,"Please Enter a number greater than 0","INVALID INPUT",JOptionPane.WARNING_MESSAGE);
		}
		
	
	}
}
