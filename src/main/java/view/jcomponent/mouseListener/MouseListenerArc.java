package view.jcomponent.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.util.List;

import view.jcomponent.Camembert;


public class MouseListenerArc implements MouseListener {

	private List<AssocitaionItemArc> values;
	private Arc2D vide;
	private Camembert camembert;

	public MouseListenerArc(List<AssocitaionItemArc> pValues, Arc2D pVide,Camembert pCamembert) {
		values = pValues;
		vide = pVide;
		camembert=pCamembert;
	}

	public void mouseClicked(MouseEvent e) {
		if (!vide.contains(e.getPoint())) {
			for (AssocitaionItemArc a : values) {
				if (a.getArc().contains(e.getPoint())) {
					camembert.setSelectedItem(a.getItem());
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
