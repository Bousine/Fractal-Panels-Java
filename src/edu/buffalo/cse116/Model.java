package edu.buffalo.cse116;

import edu.buffalo.fractal.FractalPanel;
import gui.ColorModelFactory;
import gui.Gui;
import code.BurningShipSet;
import code.JuliaSet;
import code.MandelbrotSet;
import code.MultibrotSet;



public class Model {
	
		 private FractalPanel _f = new FractalPanel();
         private double _inputDistance = 2;
         private Gui window;
         
         
         public Model(){
        	 window = new Gui(this);
        	 window.add(_f);
         }
         
         
         public void SetInputDistance(double input){
        	 _inputDistance = input;
         }
         
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
        	 
         }
         
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
        	 
         }
}
