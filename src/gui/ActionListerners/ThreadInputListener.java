package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.buffalo.cse116.Model;

public class ThreadInputListener implements ActionListener{
	
	Model _model;
	
	public ThreadInputListener(Model model){
		_model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		Integer inputValue = 1;
		String input = JOptionPane.showInputDialog("Enter a whole number greater than 0");
		
		while(true){
		try{
			if(input == null){
				throw new NullPointerException();
			}
			inputValue = Integer.parseInt(input);
			if(!(inputValue > 0)){
				throw new NumberFormatException();
			}
			_model.SetInputhread(inputValue);
			break;
		}
			
			catch(NumberFormatException d){
				input = JOptionPane.showInputDialog("Invalid value, try again");
				
			 }
		catch(NullPointerException f){
			break;
		  }
		}
		_model.updateFactal();
	}
		
		
		
		
		
	

}
