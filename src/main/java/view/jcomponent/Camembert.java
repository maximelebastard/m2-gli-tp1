package view.jcomponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import view.jcomponent.mouseListener.AssocitaionItemArc;
import view.jcomponent.mouseListener.MouseListenerArc;

import model.IItemListAdapter;
import model.Item;
import model.ItemSetAdapter;

public class Camembert extends JComponent implements Observer{

	private static final long serialVersionUID = 1L;
	
	private static final int DIAMETER = 450;
	
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
		
		final int rayonGrandCercle = DIAMETER/2;
		final int rayonCercleVide = DIAMETER/4;
		final int rayonCercleCentral= DIAMETER/8;
		
		Dimension d = getSize();
		
		Graphics2D g2d = (Graphics2D) g;
		
	    float begin = 0;
	    
	    final List<Item> items = model.getItems();
	    int total = model.getItemsNumberSum();
	   
	    //for each item, we process the part that it take on the Camembert
		for(int i = 0;i<items.size();i++){
			final Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE); 
			associationsItemArc.add(new AssocitaionItemArc(items.get(i), arc));
			arc.setFrame((d.getWidth()/2)-rayonGrandCercle, (d.getHeight()/2)-rayonGrandCercle, DIAMETER, DIAMETER);
			//begin angle
			arc.setAngleStart(begin);
			//extend angle
			float valueAngl = (items.get(i).getNumber()*360)/(float)total;
			arc.setAngleExtent(valueAngl);
			Color colorPart = generateColor(i);
			//set color 
			g2d.setColor(colorPart);
			g2d.fill(arc);
			// creation line for separate part
//			Line2D.Float line = new Line2D.Float();
//			line.setLine(arc.getEndPoint(), new Point2D.Double(d.getWidth()/2,d.getHeight()/2));
//			//increase thickness of the line
//			g2d.setStroke(new BasicStroke(5));
//			g2d.setColor(Color.white);
//			g2d.draw(line);
			
			//creation rectangle to display part name
			double x = d.getWidth()/2 + (rayonGrandCercle +50) * Math.cos(Math.toRadians(arc.getAngleStart()+valueAngl/2));
			double y = d.getHeight()/2 - (rayonGrandCercle+ 50) * Math.sin(Math.toRadians(arc.getAngleStart()+valueAngl/2));
		
			Point2D.Double point = new Point2D.Double();
			point.setLocation(x, y);
			g2d.setColor(colorPart);
			Rectangle2D.Double rect = new Rectangle2D.Double(point.x - 40, point.y - 25, 80, 50);
		
			g2d.draw(rect);
			g2d.drawString(items.get(i).getTitle(),(int) point.x -20,(int) point.y -10);
			
			begin+=valueAngl;
		}
		
	    
	   //creation void circle
		Ellipse2D ellipseVoid = new Ellipse2D.Double(d.getWidth()/2-rayonCercleVide, d.getHeight()/2 - rayonCercleVide, rayonGrandCercle, rayonGrandCercle);
		g2d.setColor(Color.white);
		g2d.fill(ellipseVoid);
		
	    //creation info circle
		Ellipse2D ellipseInfo = new Ellipse2D.Double(d.getWidth()/2-rayonCercleCentral, d.getHeight()/2 - rayonCercleCentral, rayonCercleVide, rayonCercleVide);
		g2d.setColor(Color.blue);
		g2d.fill(ellipseInfo);
		
		addMouseListener(new MouseListenerArc(associationsItemArc,new Arc2D.Double(),this));
		
		g2d.setColor(Color.black);
		if(selectedItem!=null){
			g2d.setColor(Color.white);
			g2d.drawString(selectedItem.getTitle(),(int)( d.getWidth()/2)-DIAMETER/16, (int)(d.getHeight()/2)-DIAMETER/16);
			g2d.drawString(selectedItem.getNumber().toString(),(int)( d.getWidth()/2)-DIAMETER/64, (int)d.getHeight()/2);
		}
	}
	
	public void update(Observable o, Object arg) {
		
	}
	
	/**
	 * génération d'une couleur à partir d'un entier.
	 * @param i : entier de départ permetant de générer une valeur
	 * @return une couleur 
	 */
	private Color generateColor(int i){
		int val = ((i * 6666666) + 666667) % (16581375);
		int r = (val/65025) % 255;
		int v = (val/255) % 255;
		int b = val % 255;
		return new Color(r,v,b);
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
}
