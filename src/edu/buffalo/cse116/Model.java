package edu.buffalo.cse116;

import gui.Gui;

public class Model {
         private double _inputDistance;
         
         public Model(){
        	 new Gui(this);
         }
         
         
         public void SetInput(double input){
        	 _inputDistance = input;
         }
}
