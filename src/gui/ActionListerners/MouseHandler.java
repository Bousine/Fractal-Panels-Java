package gui.ActionListerners;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.buffalo.cse116.*;

public class MouseHandler implements MouseListener, MouseMotionListener{
	private Rectangle _zoom;
	private Point _clicked;
	private Point _dragged;
	private Model _model;
	
	public MouseHandler(Model model){
		_model = model;
	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		Point _dragged = new Point();
		_dragged = me.getPoint();
		
		Component f = me.getComponent();		
		Rectangle r = new Rectangle();
		r = f.getBounds();
		int adjustedY = (int) (_dragged.y/r.getHeight() * 512);
		int adjustedX = (int) (_dragged.x/r.getWidth() * 512);
		_dragged = new Point(adjustedX, adjustedY);
		
		int xTopLeft = Math.min(_clicked.x, _dragged.x);
		int yTopLeft = Math.min(_clicked.y, _dragged.y);
		int width = Math.abs(_clicked.x - _dragged.x);
		int height = Math.abs(_clicked.y - _dragged.y);
		_zoom = new Rectangle(xTopLeft, yTopLeft, width, height);
		_model.updateFeedback("Zooming "+ _zoom);
		
		/*int xx = me.getX();
		int yy = me.getY();
		_model.selectionSizer(xx, yy);*/
	}

	@Override
	public void mousePressed(MouseEvent me) {
		_clicked = me.getPoint();
		_zoom = null;
		
		Component f = me.getComponent();
		
		Rectangle r = new Rectangle();
		r = f.getBounds();
		int adjustedY = (int) (_clicked.y/r.getHeight() * 512);
		int adjustedX = (int) (_clicked.x/r.getWidth() * 512);
		
		_clicked = new Point(adjustedX, adjustedY);
		_model.updateFeedback("Point ("+ _clicked.getX() + "," + _clicked.getX() + ") selected");
		
		/*int xx = me.getX();
		int yy = me.getY();
		_model.selectionMaker(xx, yy);*/
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		_clicked = null;
		if(_zoom != null){
		    int leftEdge = _zoom.x;
		    int rightEdge = _zoom.x + _zoom.width;
		    int topEdge = _zoom.y;
		    int bottomEdge = _zoom.y + _zoom.height;
		    _model.zoomSelection(topEdge, bottomEdge, leftEdge, rightEdge);
		    _model.updateFeedback("Zoomed  "+ _zoom);
		    
			/*[For Testing Purposes]
			System.out.println("Left Edge: " + _zoom.x);
			System.out.println("Top Edge: " + _zoom.y);
			System.out.println("Right Edge: " + (_zoom.x + _zoom.width));
			System.out.println("Bottom Edge: " + (_zoom.y + _zoom.height));*/
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
