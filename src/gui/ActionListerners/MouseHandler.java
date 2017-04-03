package gui.ActionListerners;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.buffalo.cse116.Model;

public class MouseHandler implements MouseListener, MouseMotionListener{
	private JPanel zoom = new JPanel();
	private Model _model;
	public MouseHandler(Model model){
		_model = model;
	}
	@Override
	public void mouseDragged(MouseEvent me) {
		int xx = me.getX();
		int yy = me.getY();
		
		//_model.selectionSizer(xx, yy);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		int xx = me.getX();
		int yy = me.getY();
		_model.selectionMaker(xx, yy);
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

}
