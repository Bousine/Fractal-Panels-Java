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
         private double _inputDistance;
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
        	 else{
        		 _f.setIndexColorModel(ColorModelFactory.createRainbowColorModel(256));
        	 }
        	 
         }
         
         public void SetFractal(int s){
        	 if (s==1){
        		 BurningShipSet bs = new BurningShipSet();
        		_f.updateImage(bs.fractalCalc());
        	 }
        	 if (s==2){
        		 JuliaSet js = new JuliaSet();
         		_f.updateImage(js.fractalCalc());
        	 }
        	 if (s==3){
        		 MandelbrotSet ms = new MandelbrotSet();
         		_f.updateImage(ms.fractalCalc());
        	 }
        	 else{
        		 MultibrotSet mls = new MultibrotSet();
         		_f.updateImage(mls.fractalCalc());
        	 }
        	 
         }
}
