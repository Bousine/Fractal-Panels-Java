package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.buffalo.cse116.Model;
import gui.DropDownMeun;


public class InputListener implements ActionListener{
	private Model _model;
	private DropDownMeun _menu;
	public InputListener(Model model){
		_model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException{
		double inputValue;
		String input = JOptionPane.showInputDialog("Enter a number greater than 0");
		
		do{
		try{
			inputValue = Double.parseDouble(input);
			if(!(inputValue>0)){
				throw new NumberFormatException();
			}
			_model.SetInputDistance(inputValue);
			break;
		}
		catch(NumberFormatException d){
			input = JOptionPane.showInputDialog("Invalid value, try again");
		 }
		}while(true);		
	
	}
}

