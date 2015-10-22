package model;

import java.util.List;
import java.util.Observable;

public class ItemSetAdapter extends Observable implements IItemListAdapter{
	
	private ItemSet itemSet = new ItemSet();
	
	public ItemSetAdapter(){
		super();
		itemSet.setItems(ItemSetData.generateItem());
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
	}

	public List<Item> getItems() {
		return itemSet.getItems();
	}

	public int getItemsNumberSum() {
		return itemSet.getItemsNumberSum();
	}

	public void newSetChanged() {
		setChanged();
	}
}
