package model;

import java.util.List;
import java.util.Observer;

public interface IItemListAdapter {

	List<Item> getItems();
	int getItemsNumberSum();
	
	void addItem(Item item);
	void notifyObservers();
	void addObserver(Observer o);
	void newSetChanged();
}
