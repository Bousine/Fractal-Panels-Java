package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.buffalo.cse116.Model;
import gui.DropDownMenu;


public class InputListener implements ActionListener{
	/**
	 *  reference to model
	 */
	private Model _model;
	/** constructor
	 *@param model is passed by dropdownmenu and holds reference to model
	 */
	public InputListener(Model model){
		_model = model;
	}
    /**
     * action listener function for inputListener
     */
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
		catch(NullPointerException f){
			break;
		}
		
		}while(true);		
	
	}
}

