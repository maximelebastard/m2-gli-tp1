package model;

import java.util.ArrayList;
import java.util.List;

public class ItemSetData {

	public static List<Item> generateItem(){
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("Budget","",350));
		items.add(new Item("Mobile","",200));
		items.add(new Item("Loyer","",502));
		return items;
	}
}
