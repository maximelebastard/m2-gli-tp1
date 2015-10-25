package model;

import java.util.List;
import java.util.Observable;

/**
 * adapter which adapts the ItemList for the view
 * @author maxime
 *
 */
public class ItemSetAdapter extends Observable implements IItemListAdapter{
	/**
	 * Items of the adapter
	 */
	private ItemSet itemSet = new ItemSet();
	
	/**
	 * Creates a new ItemSetAdapter without items
	 */
	public ItemSetAdapter(){
		super();
		itemSet.setItems(ItemSetData.generateItem());
	}
	
	/**
	 * Creates a new ItemSetAdapter with items
	 */
	public ItemSetAdapter(String title){
		super();
		itemSet.setTitle(title);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void addItem(Item item){
		itemSet.addItem(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> getItems() {
		return itemSet.getItems();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getItemsNumberSum() {
		return itemSet.getItemsNumberSum();
	}

	/**
	 * {@inheritDoc}
	 */
	public void newSetChanged() {
		setChanged();
	}
}
