package view.jcomponent;
import java.awt.geom.Arc2D;

import model.Item;

/**
 * A JComponent Arc2D with an item atteched on it
 * 
 * @author maxime
 *
 */
public class Arc2DItemFloat extends Arc2D.Float {
	
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 * @param arg
	 */
	public Arc2DItemFloat(int arg) {
		super(arg);
	}
	
	/**
	 * The item attached to the arc
	 */
	private Item item;

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
