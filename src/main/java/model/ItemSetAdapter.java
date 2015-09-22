package model;

import java.util.List;
import java.util.Observable;

public class ItemSetAdapter extends Observable implements IItemsModels{
	
	private ItemSet itemSet = new ItemSet();
	
	public ItemSetAdapter(){
		super();
		ite
	}
	
	public ItemSetAdapter(String title){
		super();
		itemSet.setTitle(title);
	}
	
	/**
	 * Method to add item and to notify observers
	 * @param item : item to add
	 */
	public void addItem(Item item){
		itemSet.addItem(item);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Method to remove item and to notify observers
	 * @param item : item to remove
	 */
	public void removeItem(Item item){
		itemSet.removeItem(item);
		notifyObservers();
	}

	public List<Item> getItems() {
		return itemSet.getItems();
	}

	public int getItemsNumberSum() {
		return itemSet.getItemsNumberSum();
	}
}
