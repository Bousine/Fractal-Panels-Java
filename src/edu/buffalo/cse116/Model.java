package edu.buffalo.cse116;

import edu.buffalo.fractal.FractalPanel;
import gui.ColorModelFactory;
import gui.Gui;
import code.BurningShipSet;
import code.JuliaSet;
import code.MandelbrotSet;
import code.MultibrotSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import gui.ActionListerners.*;

/**
 * Class which interacts between user input, the gui and the rest of the code. 
 * 
 * @author Mark Kayutkin
 * @author Asif Hasan
 * @author Xiangshuai Gao
 */

public class Model {
	     /**
	      * this is the fractal panel
	      */
		 private FractalPanel _f;
		 /**
	      * this is the current input distance
	      */
         private double _inputDistance;
         /**
	      * this is the current input fractal choice
	      */
         private double _inputTime;
         private JLabel _selection;
         private int _inputFractal;
         /**
          * this is the gui window
          */
         private Gui _window;
         private JLabel _VisualFeedBack;
         
         private int leftEdge;
         private int rightEdge;
         private int topEdge;
         private int bottomEdge;
         
         /**
          * constructor
          */
         public Model(){
        	 _f = new FractalPanel();
        	 _inputDistance = 2;
        	 _inputTime = 255;
        	 _inputFractal = -1;
        	 _window = new Gui(this);
        	 _window.add(_f);
        	 MouseHandler mouse = new MouseHandler(this);
        	 _f.addMouseListener(mouse);
        	 _f.addMouseMotionListener(mouse);
        	 
         }
         
         /** this sets _inputDistance to the new distance
          * 
          * @param input distance from user
          */
         public void SetInputDistance(double input){
        	 _inputDistance = input;
        	 this.updateFactal();
         }
         public void SetInputTime(double input){
        	 _inputTime = input;
        	 this.updateFactal();
         }
         
         public void updateFactal(){
        	 if(!(_inputFractal==-1)){
        	 this.SetFractal(_inputFractal);
        	 }
         }
         
         /** this changes the color setting
          * 
          * @param c input color choice from user
          */
         public void SetColor(int c){
        	 if (c==1){
        		 _f.setIndexColorModel(ColorModelFactory.createRainbowColorModel(256));
        	 }
        	 if (c==2){
        		 _f.setIndexColorModel(ColorModelFactory.createBluesColorModel(256));
        	 }
        	 if (c==3){
        		 _f.setIndexColorModel(ColorModelFactory.createGrayColorModel(256));
        	 }
        	 if (c==4){
        		 _f.setIndexColorModel(ColorModelFactory.createGreensColorModel(256));
        	 }
        	 this.updateFactal();
        	 
         }
         
         /** this updates the fractal to the user's preference
          * @param s input fractal choice from user
          */
         public void SetFractal(int s){
        	 if (s==1){
        		 BurningShipSet bs = new BurningShipSet(_inputDistance, _inputTime);
        		_f.updateImage(bs.fractalCalc());
        	 }
        	 if (s==2){
        		 JuliaSet js = new JuliaSet(_inputDistance, _inputTime);
         		_f.updateImage(js.fractalCalc());
        	 }
        	 if (s==3){
        		 MandelbrotSet ms = new MandelbrotSet(_inputDistance, _inputTime);
         		_f.updateImage(ms.returnResult());
        	 }
        	 if (s==4){
        		 MultibrotSet mls = new MultibrotSet(_inputDistance, _inputTime);
         		_f.updateImage(mls.fractalCalc());
        	 }
        	 _inputFractal = s;
         }
         
         public void zoomSelection(int topEdge, int bottomEdge, int leftEdge, int rightEdge){
        	 if(_inputFractal == 1){
        		 BurningShipSet bs = new BurningShipSet(_inputDistance, _inputTime);
        		 bs.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 _f.updateImage(bs.fractalCalc());
        	 }
        	 if(_inputFractal == 2){
        		 JuliaSet js = new JuliaSet(_inputDistance, _inputTime);
        		 js.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 _f.updateImage(js.fractalCalc());
        	 }
        	 
        	 if(_inputFractal == 3){
        		 MandelbrotSet ms = new MandelbrotSet(_inputDistance, _inputTime);
        		 ms.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 _f.updateImage(ms.fractalCalc());
        	 }
        	 if(_inputFractal == 4){
        		 MultibrotSet mls = new MultibrotSet(_inputDistance, _inputTime);
        		 mls.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 _f.updateImage(mls.fractalCalc());
        	 }
         }
         
         
         public void updateFeedback(String string){
        	 if(!(_inputFractal==-1)){
        		 _window.updateFeedback(string);
            	 }
     	}
}


