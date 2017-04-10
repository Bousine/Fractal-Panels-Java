package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Screen extends JFrame{

	private int _xStart;
	private int _yStart;
	
	private Graphics _select;
	
	public Screen(JFrame window){
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		this.setVisible(true);
		window.add(this);
	}
	
	public void paint(Graphics select) {
		select.drawRect(_xStart, _yStart, 0, 0);
		
	}

	public void selectCoords(int xx, int yy) {
		_xStart = xx;
		_yStart = yy;
		
	}
}
