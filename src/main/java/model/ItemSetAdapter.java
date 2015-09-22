package model;

import java.util.Observable;
import java.util.Observer;

public class ItemSetAdapter extends Observable{
	
	private ItemSet itemSet = new ItemSet();
	
	public ItemSetAdapter(){
		super();
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
}
