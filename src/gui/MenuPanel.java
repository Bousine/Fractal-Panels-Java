package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.ActionListerners.ExitListener;


public class MenuPanel extends JPanel{
	
	public MenuPanel(){
		super();
		this.setLayout(new GridLayout(0,4));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.MasterSetUP();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This makes me so dizzy. I a placing it all the way at the back if you don't mind
	 * 
	 */
	public void MasterSetUP(){
		this.add(new JLabel("File:"));
		this.add(new JLabel("Fractal:"));
		this.add(new JLabel("Color:"));
		this.add(new JLabel("Escape Time:"));
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ExitListener());
		this.add(Exit);
		JButton bsset = new JButton("Burning Ship");
		this.add(bsset);
		JButton color1 = new JButton("Color 1");
		this.add(color1);
		this.add(new JTextField());
		
		this.add(new JLabel());
		JButton jset = new JButton("Julia");
		this.add(jset);
		JButton color2 = new JButton("Color 2");
		this.add(color2);
		JButton submit = new JButton("Submit");
		this.add(submit);
		
		this.add(new JLabel());
		JButton mbset = new JButton("MandelBrot");
		this.add(mbset);
		JButton color3 = new JButton("Color 3");
		this.add(color3);
		this.add(new JLabel());
		
		this.add(new JLabel());
		JButton mtset = new JButton("MultiBrot");
		this.add(mtset);
		JButton color4 = new JButton("Color 4");
		this.add(color4);
		this.add(new JLabel());
		
	}
	
	

}
