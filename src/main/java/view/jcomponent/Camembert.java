package view.jcomponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import view.jcomponent.mouseListener.MouseListenerArc;

import model.IItemListAdapter;
import model.Item;

public class Camembert extends JComponent {

	private static final long serialVersionUID = 1L;

	private static final int DIAMETER = 450;

	private IItemListAdapter model;
	private Integer selectedIndex;
	private List<Arc2DItemFloat> arcs;
	private Rectangle2D.Double rectangle2dPrev ;
	private Rectangle2D.Double rectangle2dNext;
	private Ellipse2D ellipseVoid;
	
	public Rectangle2D.Double getRectangle2dPrev() {
		return rectangle2dPrev;
	}

	public Rectangle2D.Double getRectangle2dNext() {
		return rectangle2dNext;
	}

	public Camembert(IItemListAdapter pModel) {
		super();
		model = pModel;

		// when we click on a part of the camembert, we have some info
		addMouseListener(new MouseListenerArc(this));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		final int rayonGrandCercle = DIAMETER / 2;
		final int rayonCercleVide = DIAMETER / 4;
		final int rayonCercleCentral = DIAMETER / 8;

		Dimension d = getSize();

		Graphics2D g2d = (Graphics2D) g;

		float begin = 0;

		final List<Item> items = model.getItems();
		int total = model.getItemsNumberSum();
		arcs = new ArrayList<Arc2DItemFloat>();
		// for each item, we process the part that it take on the Camembert
		for (int i = 0; i < items.size(); i++) {

			// if the user have entered a value for this item
			if (items.get(i).getNumber() != null && items.get(i).getTitle()!=null) {
				// Create the arc and affect the right item
				final Arc2DItemFloat arc = new Arc2DItemFloat(Arc2D.PIE);
				arc.setItem(items.get(i));

				// associationsItemArc.add(new AssocitaionItemArc(items.get(i),
				// arc));
				arcs.add(arc);
				if (selectedIndex != null && i == selectedIndex) {
					arc.setFrame((d.getWidth() / 2) - rayonGrandCercle - 10,
							(d.getHeight() / 2) - rayonGrandCercle - 10, DIAMETER + 20, DIAMETER + 20);
				} else {
					arc.setFrame((d.getWidth() / 2) - rayonGrandCercle, (d.getHeight() / 2) - rayonGrandCercle,
							DIAMETER, DIAMETER);
				}

				// begin angle
				arc.setAngleStart(begin);
				// extend angle
				float valueAngl = (items.get(i).getNumber() * 360) / (float) total;
				arc.setAngleExtent(valueAngl);
				Color colorPart = generateColor(i);
				// set color
				g2d.setColor(colorPart);
				g2d.fill(arc);

				// creation rectangle to display part name
				double x = d.getWidth() / 2
						+ (rayonGrandCercle + 55) * Math.cos(Math.toRadians(arc.getAngleStart() + valueAngl / 2));
				double y = d.getHeight() / 2
						- (rayonGrandCercle + 55) * Math.sin(Math.toRadians(arc.getAngleStart() + valueAngl / 2));

				// Draw the label
				Point2D.Double point = new Point2D.Double(x, y);
				g2d.setColor(colorPart);
				Rectangle2D.Double rect = new Rectangle2D.Double(point.x - 40, point.y - 25, 80, 50);

				g2d.draw(rect);
				g2d.drawString(items.get(i).getTitle(), (int) point.x - 20, (int) point.y - 10);

				begin += valueAngl;
			}
		}

		// creation void circle
		ellipseVoid = new Ellipse2D.Double(d.getWidth() / 2 - rayonCercleVide,
				d.getHeight() / 2 - rayonCercleVide, rayonGrandCercle, rayonGrandCercle);
		g2d.setColor(Color.white);
		g2d.fill(ellipseVoid);

		// creation info circle
		Ellipse2D ellipseInfo = new Ellipse2D.Double(d.getWidth() / 2 - rayonCercleCentral,
				d.getHeight() / 2 - rayonCercleCentral, rayonCercleVide, rayonCercleVide);
		g2d.setColor(Color.blue);
		g2d.fill(ellipseInfo);
		
		rectangle2dPrev = new Rectangle2D.Double(500, 600, 50, 40);
		g2d.setColor(Color.black);
		g2d.draw(rectangle2dPrev);
		g2d.drawString("prev",505,615);
		rectangle2dNext = new Rectangle2D.Double(600, 600, 50, 40);
		g2d.setColor(Color.black);
		g2d.draw(rectangle2dNext);
		g2d.drawString("next",605,615);
		
		// the selected Item is displayed in the info circle
		g2d.setColor(Color.black);
		if (selectedIndex != null) {
			g2d.setColor(Color.white);
			g2d.drawString(items.get(selectedIndex).getTitle(), (int) (d.getWidth() / 2) - DIAMETER / 16,
					(int) (d.getHeight() / 2) - DIAMETER / 16);
			g2d.drawString(items.get(selectedIndex).getNumber().toString(), (int) (d.getWidth() / 2) - DIAMETER / 64,
					(int) d.getHeight() / 2);
		}
	}

	/**
	 * génération d'une couleur à partir d'un entier.
	 * 
	 * @param i
	 *            : entier de départ permetant de générer une valeur
	 * @return une couleur
	 */
	private Color generateColor(int i) {
		int val = ((i * 6666666) + 666667) % (16581375);
		int r = (val / 65025) % 255;
		int v = (val / 255) % 255;
		int b = val % 255;
		return new Color(r, v, b);
	}

	public void setSelectedIndex(Integer selectedIndex) {
		this.selectedIndex = selectedIndex % model.getItems().size();
		if(this.selectedIndex<0){
			this.selectedIndex=model.getItems().size()-1;
		}
	}

	public Integer getSelectedIndex() {
		return selectedIndex;
	}

	/**
	 * @return the arcs
	 */
	public List<Arc2DItemFloat> getArcs() {
		return arcs;
	}
	
	public Ellipse2D getEllipseVoid(){
		return ellipseVoid;
	}

}
