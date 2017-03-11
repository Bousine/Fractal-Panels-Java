package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Gui implements Runnable {
	public void gui() {
		
	}

	@Override
	public void run() {
		int w = 600;
		int h = 600;
		JFrame window = new JFrame("Fractal Builder");
		window.setSize(w, h);
		window.getContentPane().setLayout(new GridLayout(6,3));
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(0,4));
		window.add(menu);
		menu.setBorder(BorderFactory.createLineBorder(Color.black));
		menu.add(new JLabel("File:"));
		menu.add(new JLabel("Fractal:"));
		menu.add(new JLabel("Color:"));
		menu.add(new JLabel("Escape Time:"));
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ExitListener());
		menu.add(exit);
		JButton bsset = new JButton("Burning Ship");
		menu.add(bsset);
		JButton color1 = new JButton("Color 1");
		menu.add(color1);
		menu.add(new JTextField());
		
		menu.add(new JLabel());
		JButton jset = new JButton("Julia");
		menu.add(jset);
		JButton color2 = new JButton("Color 2");
		menu.add(color2);
		JButton submit = new JButton("Submit");
		menu.add(submit);
		
		menu.add(new JLabel());
		JButton mbset = new JButton("MandelBrot");
		menu.add(mbset);
		JButton color3 = new JButton("Color 3");
		menu.add(color3);
		menu.add(new JLabel());
		
		menu.add(new JLabel());
		JButton mtset = new JButton("MultiBrot");
		menu.add(mtset);
		JButton color4 = new JButton("Color 4");
		menu.add(color4);
		menu.add(new JLabel());
	}
}
