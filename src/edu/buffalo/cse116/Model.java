package edu.buffalo.cse116;

import java.util.Arrays;

import code.*;
import gui.Gui;

public class Model {
         private double _inputDistance;
         private BurningShipSet _bs;
         private JuliaSet _j;
         private MandelbrotSet _mandel;
         private MultibrotSet _multi;
         
         public Model(){
        	 new Gui(this);
        	 _bs = new BurningShipSet();
        	 _j = new JuliaSet();
        	 _mandel = new MandelbrotSet();
        	 _multi = new MultibrotSet();
         }
         
         
         public void SetInput(double input){
        	 _inputDistance = input;
         }
         
         public void escapeDistUpdate(){
        	 _bs.setEscapeDistance(_inputDistance);
        	 _bs.fractalCalc();//To be modified
        	 _j.setEscapeDistance(_inputDistance);
        	 _j.fractalCalc();//To be modified
        	 _mandel.setEscapeDistance(_inputDistance);
        	 _mandel.fractalCalc();//To be modified
        	 _multi.setEscapeDistance(_inputDistance);
        	 _multi.fractalCalc();//To be modified
         }
}
