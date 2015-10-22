package view.jcomponent.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;

import view.jcomponent.Arc2DItemFloat;
import view.jcomponent.Camembert;


public class MouseListenerArc implements MouseListener {
	
	/**
	 * The camembert graph (with its arcs)
	 */
	private Camembert camembert;

	public MouseListenerArc(Camembert pCamembert) {
		camembert=pCamembert;
	}

	public void mouseClicked(MouseEvent e) {
		// Check that we are not in the white mask
		if (!camembert.getEllipseVoid().contains(e.getPoint())) {
			
			if(camembert.getRectangle2dNext().contains(e.getPoint()) && camembert.getSelectedIndex() != null){
				camembert.setSelectedIndex(camembert.getSelectedIndex()+1);
				camembert.repaint();
				return;
			}
			
			if(camembert.getRectangle2dPrev().contains(e.getPoint()) && camembert.getSelectedIndex() != null){
				camembert.setSelectedIndex(camembert.getSelectedIndex()-1);
				camembert.repaint();
				return;
			}
			
			
			// For all the arcs, check if the point is in one of them
			for(int i=0;i<camembert.getArcs().size();i++) {
				
				// If the arc is on the selected point
				if(camembert.getArcs().get(i).contains(e.getPoint())) {
					camembert.setSelectedIndex(i);
					camembert.repaint();
					
					return;
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
