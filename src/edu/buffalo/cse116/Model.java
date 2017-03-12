package edu.buffalo.cse116;

import gui.Gui;

public class Model {
         private double _inputDistance;
         private Gui window;
         
         public Model(){
        	 window = new Gui(this);
         }
         
         
         public void SetInputDistance(double input){
        	 _inputDistance = input;
        	 
         }
}
