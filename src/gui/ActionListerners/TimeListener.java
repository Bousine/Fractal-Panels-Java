package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.buffalo.cse116.Model;
import gui.DropDownMenu;

/**
 * Class which listens to user input for time
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao
 */
public class TimeListener implements ActionListener{
	/**
	 *  reference to model
	 */
	private Model _model;
	/** constructor
	 *@param model is passed by dropdownmenu and holds reference to model
	 */
	public TimeListener(Model model){
		_model = model;
	}
    /**
     * action listener function for inputListener
     */
	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException{
		double inputValue;
		String input = JOptionPane.showInputDialog("Enter a number between 1 and 255");
		
		do{
		try{
			inputValue = Double.parseDouble(input);
			if((inputValue < 1 || inputValue > 255)){
				throw new NumberFormatException();
			}
			_model.SetInputTime(inputValue);
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

