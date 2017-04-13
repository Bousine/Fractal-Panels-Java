package gui.ActionListerners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Class which listens to user input for exiting
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao
 */
public class ExitListener implements ActionListener{
	/**
     * action listener function for exitListener
     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		
	}

}
