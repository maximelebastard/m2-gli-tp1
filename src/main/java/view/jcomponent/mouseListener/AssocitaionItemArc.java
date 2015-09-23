package view.jcomponent.mouseListener;

import java.awt.geom.Arc2D;

import model.Item;

public class AssocitaionItemArc {

	private Item item;
	private Arc2D arc;
	
	public AssocitaionItemArc(Item pItem,Arc2D pArc){
		arc=pArc;
		item=pItem;
	}

	public Item getItem() {
		return item;
	}

	public Arc2D getArc() {
		return arc;
	}

}
