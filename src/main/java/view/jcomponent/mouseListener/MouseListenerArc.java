package view.jcomponent.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.util.List;

import view.jcomponent.Arc2DItemFloat;
import view.jcomponent.Camembert;


public class MouseListenerArc implements MouseListener {
	
	/**
	 * The empty circle (white mask)
	 */
	private Arc2D vide;
	
	/**
	 * The camembert graph (with its arcs)
	 */
	private Camembert camembert;

	public MouseListenerArc(Arc2D pVide,Camembert pCamembert) {
		vide = pVide;
		camembert=pCamembert;
	}

	public void mouseClicked(MouseEvent e) {
		// Check that we are not in the white mask
		if (!vide.contains(e.getPoint())) {
			
			// For all the arcs, check if the point is in one of them
			for(Arc2DItemFloat arc : camembert.getArcs()) {
				
				// If the arc is on the selected point
				if(arc.contains(e.getPoint())) {
					camembert.setSelectedItem(arc.getItem());
					camembert.repaint();
					
					return;
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
