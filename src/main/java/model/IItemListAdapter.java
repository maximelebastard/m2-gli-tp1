package model;

import java.util.List;
import java.util.Observer;

/**
 * Interface of the adapter which adapts the ItemList for the view
 *
 * @author romain
 *
 */
public interface IItemListAdapter {

	/**
	 * Returns the items of the ItemList
	 * @return List<Item> The items
	 */
	List<Item> getItems();
	
	/**
	 * Makes the sum of the item numbers of the list
	 * @return int The sum
	 */
	int getItemsNumberSum();
	
	/**
	 * Adds a new item
	 * @param item The item to add
	 */
	void addItem(Item item);
	
	/**
	 * Notifies the observers that the model has changed
	 */
	void notifyObservers();
	
	/**
	 * Adds a new observer of the adapter
	 * @param o The new observer
	 */
	void addObserver(Observer o);
	
	/**
	 * 
	 */
	void newSetChanged();
}
