package edu.buffalo.cse116;

import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.FractalPanel;
import edu.buffalo.fractal.WorkerResult;
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
	
	    // this does nothing until we can implement mutithreading.
	    // Since set classes do the actual calculations, we should implement threading there.  
	     private int _ThreadInput;
	
	     /**
	      * this is the fractal panel
	      */
		 private FractalPanel _f;
		 /**
	      * this is the current input distance
	      */
         private double _inputDistance;
         /**
	      * this is the current input time
	      */
         private double _inputTime;
         /**
          * this is the gui window
          */
         private Gui _window;
         
         private int _startingRow;
         
        private int _colorInput;
         
        private  ComputePool _pool;
         
        private  SwingWorker<WorkerResult, Void>[] _workers;
        
        private int _fractalInput;
         /**
          * constructor
          */
         public Model(){
        	 _f = new FractalPanel();
        	 _workers = null;
        	 _pool = new ComputePool();
        	 _f.setSize(2048, 2048);
        	 _inputDistance = 2;
        	 _inputTime = 255;
        	 _ThreadInput = 1;
        	 _colorInput = 1;
        	 _fractalInput = 0;
        	 _window = new Gui(this);
        	 _window.add(_f);
        	 MouseHandler mouse = new MouseHandler(this);
        	 _f.addMouseListener(mouse);
        	 _f.addMouseMotionListener(mouse);
        	 this.SetColor(_colorInput);
        	 _startingRow = 0;
         }
         
         public void SetInputhread(int input){
        	 _ThreadInput = input;
         }
         
         /** this sets _inputDistance to the new distance
          * 
          * @param input distance from user
          */
         public void SetInputDistance(double input){
        	 _inputDistance = input;
        	
         }
         /** this sets _inputTime to the new time
          * 
          * @param input time from user
          */
         public void SetInputTime(double input){
        	 _inputTime = input;
        	
         }
         /**
          * updates fractal
          */
         public void updateFactal(){
        	 if(_workers!=null){
        	 _pool.changePanel(_f);
        	 this.SetColor(_colorInput);
        	 this.SetFractal(_fractalInput);
        	 _pool.generateFractal(2048/_ThreadInput, _workers);
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
        	 _colorInput = c;
        	
         }
         
         /** this updates the fractal to the user's preference
          * @param s input fractal choice from user
          */
         public void SetFractal(int s){
        	 //pretty sure issue lies here and it has something to do with the starterRow
        	 int starterRow = _startingRow;
        	 _fractalInput = s;
        	 if (s==1){
        		 _workers = new BurningShipSet[_ThreadInput];
        		 for(int i = 0; i<_ThreadInput; i++){
        		 _workers[i] = new BurningShipSet(_inputDistance, _inputTime, starterRow, 2048/_ThreadInput);
        		 if(starterRow<2048){
            		 starterRow = 2048/_ThreadInput;
        		}
        		 }
        	 }
        	 if (s==2){
        		 _workers = new JuliaSet[_ThreadInput];
        		 for(int i = 0; i<_ThreadInput; i++){
        		 _workers[i] = new JuliaSet(_inputDistance, _inputTime, starterRow, 2048/_ThreadInput);
        		if(starterRow<2048){
            		 starterRow = 2048/_ThreadInput;
        		}
        		 }
        	 }
        	 if (s==3){
        		 _workers = new MandelbrotSet[_ThreadInput];
        		 for(int i = 0; i<_ThreadInput; i++){
        		 _workers[i] = new MandelbrotSet(_inputDistance, _inputTime, starterRow, 2048/_ThreadInput);
        		 if(starterRow<2048){
            		 starterRow = 2048/_ThreadInput;
        		}
        		 }
        	 }
        	 if (s==4){
        		 _workers = new MultibrotSet[_ThreadInput];
        		 for(int i = 0; i<_ThreadInput; i++){
        		 _workers[i] = new MultibrotSet(_inputDistance, _inputTime, starterRow, 2048/_ThreadInput);
        		 if(starterRow<2048){
            		 starterRow = 2048/_ThreadInput;
        		} 
        		 }
        	 }
           
        	
        	
         }
         /**
          * Recalculates fractal display using new zoomed coordinates and dimensions
          * @param topEdge- start of y coordinates
          * @param bottomEdge- end of y coordinates
          * @param leftEdge- start of x coordinates
          * @param rightEdge- end of x coordinates
          */
        public void zoomSelection(int topEdge, int bottomEdge, int leftEdge, int rightEdge){
        	 if(_fractalInput == 1){
        		 BurningShipSet bs = new BurningShipSet(_inputDistance, _inputTime, 0, 2048);
        		 bs.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 this.updateFactal();
        	 }
        	 if(_fractalInput == 2){
        		 JuliaSet js = new JuliaSet(_inputDistance, _inputTime, 0, 2048);
        		 js.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 this.updateFactal();
        	 }
        	 
        	 if(_fractalInput == 3){
        		 MandelbrotSet ms = new MandelbrotSet(_inputDistance, _inputTime, 0, 2048);
        		 ms.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 this.updateFactal();
        	 }
        	 if(_fractalInput == 4){
        		 MultibrotSet mls = new MultibrotSet(_inputDistance, _inputTime, 0, 2048);
        		 mls.zoomInitialize(leftEdge, rightEdge, topEdge, bottomEdge);
        		 this.updateFactal();
        	 }
        	 
         }
         
         /**
     	 * updates zoom coordinates and dimensions to display
     	 * @param string- zoom coordinates and dimensions
     	 */
         public void updateFeedback(String string){
        	 if(_workers!=null){
        		 _window.updateFeedback(string);
            	 }
     	}
         
        public void changeStart(int start){
        	_startingRow = start;
        }
        
        public void updateZoom(){
        	
        }
}


