package view.jcomponent;
import java.awt.geom.Arc2D;

import model.Item;

public class Arc2DItemFloat extends Arc2D.Float {
	
	private static final long serialVersionUID = 1L;

	public Arc2DItemFloat(int arg) {
		super(arg);
	}
	
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
