package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener{
	
	/**
	 * ActionListener for exit button
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		
	}

}
