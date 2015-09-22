package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import model.IModel;
import model.Item;
import model.ItemSetAdapter;

public class Camembert extends JComponent implements Observer{

	private static final long serialVersionUID = 1L;
	
	private static final int RAYON_CERCLE = 500;
	
	private IModel model = new ItemSetAdapter();
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Dimension d = getSize();

		Graphics2D g2d = (Graphics2D) g;
		Arc2D.Float cercle = new Arc2D.Float(Arc2D.PIE);
		cercle.setFrame((d.getWidth()/2)-(RAYON_CERCLE/2), (d.getHeight()/2)-(RAYON_CERCLE/2), RAYON_CERCLE, RAYON_CERCLE);
	    cercle.setAngleStart(0);
	    cercle.setAngleExtent(380);
	    
	    Arc2D.Float vide = new Arc2D.Float(Arc2D.PIE);
	    vide.setFrame((d.getWidth()/2)-(RAYON_CERCLE/4), (d.getHeight()/2)-(RAYON_CERCLE/4), RAYON_CERCLE/2, RAYON_CERCLE/2);
	    vide.setAngleStart(0);
	    vide.setAngleExtent(380);
	    
	    Arc2D.Float info = new Arc2D.Float(Arc2D.PIE);
	    info.setFrame((d.getWidth()/2)-(RAYON_CERCLE/8), (d.getHeight()/2)-(RAYON_CERCLE/8), RAYON_CERCLE/4, RAYON_CERCLE/4);
	    info.setAngleStart(0);
	    info.setAngleExtent(380);
	    
	    g2d.setColor(Color.red);
		g2d.fill(cercle);
		g2d.setColor(Color.white);
		g2d.fill(vide);
		g2d.setColor(Color.blue);
		g2d.fill(info);
	}
	
	private void constructDiagram(){
		ItemSetAdapter itemSet = (ItemSetAdapter)model;
		List<Item> items = itemSet.getItems();
		
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
