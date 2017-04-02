package edu.buffalo.cse116;

import edu.buffalo.fractal.FractalPanel;
import gui.ColorModelFactory;
import gui.Gui;
import code.BurningShipSet;
import code.JuliaSet;
import code.MandelbrotSet;
import code.MultibrotSet;

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
		 private FractalPanel _f = new FractalPanel();
		 /**
	      * this is the current input distance
	      */
         private double _inputDistance = 2;
         /**
	      * this is the current input fractal choice
	      */
         private int _inputFractal = -1;
         /**
          * this is the gui window
          */
         private Gui _window;
         
         
         /**
          * constructor
          */
         public Model(){
        	 _window = new Gui(this);
        	 _window.add(_f);
         }
         
         /** this sets _inputDistance to the new distance
          * 
          * @param input distance from user
          */
         public void SetInputDistance(double input){
        	 _inputDistance = input;
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
          * 
          * @param s input fractal choice from user
          */
         public void SetFractal(int s){
        	 if (s==1){
        		 BurningShipSet bs = new BurningShipSet(_inputDistance);
        		_f.updateImage(bs.fractalCalc());
        	 }
        	 if (s==2){
        		 JuliaSet js = new JuliaSet(_inputDistance);
         		_f.updateImage(js.fractalCalc());
        	 }
        	 if (s==3){
        		 MandelbrotSet ms = new MandelbrotSet(_inputDistance);
         		_f.updateImage(ms.returnResult());
        	 }
        	 if (s==4){
        		 MultibrotSet mls = new MultibrotSet(_inputDistance);
         		_f.updateImage(mls.fractalCalc());
        	 }
        	 _inputFractal = s;
         }
}
