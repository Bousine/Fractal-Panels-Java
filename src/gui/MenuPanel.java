package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import code.*;
import gui.ActionListerners.*;


public class MenuPanel extends JPanel{
	
	private BurningShipSet _bs;
	private JuliaSet _js;
	private MandelbrotSet _mandel;
	private MultibrotSet _multi;
	
	public MenuPanel(){
		super();
		this.setLayout(new GridLayout(0,4));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.MasterSetUP();
		
		_bs = new BurningShipSet();
		_js = new JuliaSet();
		_mandel = new MandelbrotSet();
		_multi = new MultibrotSet();
		
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
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		formatter.setAllowsInvalid(true);
		JFormattedTextField field = new JFormattedTextField(formatter);
		ActionListener x = new InputListener(field, _bs, _js, _mandel, _multi);
		field.addActionListener(x);
		this.add(field);
		
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
		
		_bs.addObserver(this);
		_js.addObserver(this);
		_mandel.addObserver(this);
		_multi.addObserver(this);
	}
	
	

}
