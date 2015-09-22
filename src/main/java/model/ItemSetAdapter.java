package model;

import java.util.Observable;
import java.util.Observer;

public class ItemSetAdapter extends ItemSet{
	
	private Observable observable = new Observable();
	
	public ItemSetAdapter(){
		super();
	}
	
	/**
	 * Method to add item and to notify observers
	 * @param item : item to add
	 */
	public void addItem(Item item){
		super.addItem(item);
		observable.notifyObservers();
	}
	
	/**
	 * Method to remove item and to notify observers
	 * @param item : item to remove
	 */
	public void removeItem(Item item){
		super.removeItem(item);
		observable.notifyObservers();	
	}


	public void addObserver(Observer observer) {
		observable.addObserver(observer);
	}

	public void removeObserver(Observer observer) {
		observable.deleteObserver(observer);
	}
}
