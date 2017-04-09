package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.buffalo.cse116.Model;
import gui.ActionListerners.*;

/**
 * Class which sets up menu bar
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao 
 */
public class DropDownMenu extends JMenuBar{
	/** I have no idea what this is, eclipse add it for me
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  instance of model
	 */
	private Model _model;
	/** Constructor
	 * 
	 * @param model this is reference to model passed by model itself to gui and from gui to dropdownmenu
	 */
	
	private JTextField _VisualFeedBack;
	
	
	public DropDownMenu(Model model){
		super();
		_model = model;
		this.MasterSetUP();
		
	}
	
	/**
	 * This sets up the entire drop down menu
	 * 
	 */
	public void MasterSetUP(){
		JMenu file = new JMenu("File");
		JMenu fractals = new JMenu("Fractals");
		JMenu colors = new JMenu("Colors");
		JMenu distance = new JMenu("Distance");
		JMenu time = new JMenu("Time");
		JMenu ZoomOption = new JMenu("Zoom Options");
		
		_VisualFeedBack = new JTextField("Selected Zoomed coordinates will appear here");
		_VisualFeedBack.setEditable(false);
		Font font = _VisualFeedBack.getFont();  
		_VisualFeedBack.setFont(font.deriveFont(Font.BOLD));
		_VisualFeedBack.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ExitListener());
		
		JMenuItem burning = new JMenuItem("Burning ship set");
		burning.addActionListener(new SetListener(_model, 1));
		JMenuItem julia = new JMenuItem("Julia set");
		julia.addActionListener(new SetListener(_model, 2));
		JMenuItem mandel = new JMenuItem("Mandelbrot set");
		mandel.addActionListener(new SetListener(_model, 3));
		JMenuItem multi = new JMenuItem("Multibrot set");
		multi.addActionListener(new SetListener(_model, 4));
		
		JMenuItem color1 = new JMenuItem("Raindow");
		color1.addActionListener(new ColorListener(_model, 1));
		JMenuItem color2 = new JMenuItem("Blues");
		color2.addActionListener(new ColorListener(_model, 2));
		JMenuItem color3 = new JMenuItem("Gray");
		color3.addActionListener(new ColorListener(_model, 3));
		JMenuItem color4 = new JMenuItem("Greens");
		color4.addActionListener(new ColorListener(_model, 4));
		
		JMenuItem submit= new JMenuItem("New Escape Distance");
		submit.addActionListener(new InputListener(_model));
		
		JMenuItem timeSet= new JMenuItem("New Escape Time");
		timeSet.addActionListener(new TimeListener(_model));
		
		JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(new ResetListener(_model));
		
		 
		
		
		file.add(exit);
		fractals.add(burning);
		fractals.add(julia);
		fractals.add(mandel);
		fractals.add(multi);
		colors.add(color1);
		colors.add(color2);
		colors.add(color3);
		colors.add(color4);
		distance.add(submit);
		time.add(timeSet);
		ZoomOption.add(reset);
		
		this.add(file);
		this.add(fractals);
		this.add(colors);
		this.add(distance);
		this.add(time);
		this.add(ZoomOption);
		this.add(new JPanel());
		this.add(_VisualFeedBack);		
	}
	
	
	public void updateFeedback(String string){
		_VisualFeedBack.setText(string);
	}
	
	

}
