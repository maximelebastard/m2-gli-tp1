package view.jcomponent;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.jcomponent.mouseListener.AssocitaionItemArc;
import view.jcomponent.mouseListener.MouseListenerArc;

import model.IItemListAdapter;
import model.Item;
import model.ItemSetAdapter;

public class Camembert extends JComponent implements Observer{

	private static final long serialVersionUID = 1L;
	
	private static final int RAYON_CERCLE = 450;
	
	private IItemListAdapter model;
	private Item selectedItem;
	private List<AssocitaionItemArc> associationsItemArc = new ArrayList<AssocitaionItemArc>();
	
	public Camembert(){
		super();
		 model = new ItemSetAdapter();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Dimension d = getSize();
		
		Graphics2D g2d = (Graphics2D) g;
		
	    float begin = 0;
	    
	    final List<Item> items = model.getItems();
	    int total = model.getItemsNumberSum();
	   
	    //for each item, we process the part that it take on the Camembert
		for(int i = 0;i<items.size();i++){
			final Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE); 
			associationsItemArc.add(new AssocitaionItemArc(items.get(i), arc));
			arc.setFrame((d.getWidth()/2)-(RAYON_CERCLE/2), (d.getHeight()/2)-(RAYON_CERCLE/2), RAYON_CERCLE, RAYON_CERCLE);
			//begin angle
			arc.setAngleStart(begin);
			//extend angle
			float valueAngl = (items.get(i).getNumber()*360)/(float)total;
			arc.setAngleExtent(valueAngl);
			
			//set color 
			g2d.setColor(generateColor(i));
			g2d.fill(arc);
			// creation line
			Line2D.Float line = new Line2D.Float();
			line.setLine(arc.getEndPoint(), new Point2D.Double(d.getWidth()/2,d.getHeight()/2));
			//increase thickness of the line
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.white);
			g2d.draw(line);
			
			begin+=valueAngl;
		}
		
	    
	   //creation void circle
	    Arc2D.Float vide = new Arc2D.Float(Arc2D.PIE);
	    vide.setFrame((d.getWidth()/2)-(RAYON_CERCLE/4), (d.getHeight()/2)-(RAYON_CERCLE/4), RAYON_CERCLE/2, RAYON_CERCLE/2);
	    vide.setAngleStart(0);
	    vide.setAngleExtent(360);
	    
	    g2d.setColor(Color.white);
		g2d.fill(vide);
		
	    //creation info circle
	    Arc2D.Float info = new Arc2D.Float(Arc2D.PIE);
	    info.setFrame((d.getWidth()/2)-(RAYON_CERCLE/8), (d.getHeight()/2)-(RAYON_CERCLE/8), RAYON_CERCLE/4, RAYON_CERCLE/4);
	    info.setAngleStart(0);
	    info.setAngleExtent(360);
	    
		g2d.setColor(Color.blue);
		g2d.fill(info);
		
		addMouseListener(new MouseListenerArc(associationsItemArc,vide,this));

		g2d.setColor(Color.black);
		if(selectedItem!=null){
			g2d.setColor(Color.white);
			g2d.drawString(selectedItem.getTitle(),(int)( d.getWidth()/2)-RAYON_CERCLE/16, (int)(d.getHeight()/2)-RAYON_CERCLE/16);
			g2d.drawString(selectedItem.getNumber().toString(),(int)( d.getWidth()/2)-RAYON_CERCLE/64, (int)d.getHeight()/2);
		}
	}
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * génération d'une couleur à partir d'un entier.
	 * @param i : entier de départ permetant de générer une valeur
	 * @return une couleur 
	 */
	private Color generateColor(int i){
		int val = ((i * 6666666) + 666667) % (255*255*255);
		int r = (val/(255*255)) % 255;
		int v = (val/255) % 255;
		int b = val % 255;
		return new Color(r,v,b);
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
}
