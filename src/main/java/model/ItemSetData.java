package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An item set with data (for testing)
 * 
 * @author maxime
 *
 */
public class ItemSetData {

	/**
	 * Generates a new Items list with data
	 * @return List<Item>
	 */
	public static List<Item> generateItem(){
		List<Item> items = new ArrayList<Item>();

		items.add(new Item("Loyer","",1));
		items.add(new Item("test","",4));
		items.add(new Item("Budget","",10));
		items.add(new Item("Mobile","",1));
		
		return items;
	}
}
