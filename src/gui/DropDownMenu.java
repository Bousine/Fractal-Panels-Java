package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import edu.buffalo.cse116.Model;
import gui.ActionListerners.ColorListener;
import gui.ActionListerners.SetListener;
import gui.ActionListerners.ExitListener;
import gui.ActionListerners.InputListener;


public class DropDownMenu extends JMenuBar{
	private static final long serialVersionUID = 1L;
	private Model _model;
	
	public DropDownMenu(Model model){
		super();
		_model = model;
		this.MasterSetUP();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	/**
	 * This makes me so dizzy. I am placing it all the way at the back if you don't mind
	 * 
	 */
	public void MasterSetUP(){
		JMenu file = new JMenu("File");
		JMenu fractals = new JMenu("Fractals");
		JMenu colors = new JMenu("Colors");
		JMenu distance = new JMenu("Distance");
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
		JMenuItem color4 = new JMenuItem("color 4");
		color4.addActionListener(new ColorListener(_model, 4));
		
		JMenuItem submit= new JMenuItem("New Escape Distance");
		submit.addActionListener(new InputListener(_model));
		
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
		
		this.add(file);
		this.add(fractals);
		this.add(colors);
		this.add(distance);
		
	}
	
	

}
