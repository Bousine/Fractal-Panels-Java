package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.buffalo.fractal.FractalPanel;

public class Gui {
	public void gui() {
		FractalPanel f = new FractalPanel();
		int w = 600;
		int h = 600;
		JFrame window = new JFrame("Fractal Builder");
		window.setSize(w, h);
		window.getContentPane().setLayout(new GridLayout(4, 3));
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel fileMenu = new JPanel();
		JPanel fractalMenu = new JPanel();
		JPanel colorMenu = new JPanel();
		JPanel fractalView = new JPanel();
		window.add(fileMenu);
		fileMenu.setSize((w/3), (h/4));
		window.add(fractalMenu);
		window.add(colorMenu);
		window.add(fractalView);
		fileMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		fileMenu.add(new JButton());
		fractalMenu.add(new JButton());
		colorMenu.add(new JButton());
		fractalView.add(new JButton());
	}
}
