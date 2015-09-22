/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maxime
 *
 */
public class ItemSet implements IModel{
	
	/**
	 * @var title The itemset title
	 */
	private String title;
	
	/**
	 * @var items Items of the itemset
	 */
	private List<Item> items;

	
	public ItemSet() {
		super();
	}
	
	public ItemSet(String title) {
		super();
		this.setTitle(title);
		this.setItems(new ArrayList<Item>());
	}
	
	public ItemSet(String title, List<Item> items) {
		super();
		this.setTitle(title);
		this.setItems(items);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Adds a new item in the set
	 * 
	 * @param item The item to add
	 */
	public void addItem(Item item){
		this.items.add(item);
	}
	
	/**
	 * Removes an item from the set
	 * 
	 * @param item The item to remove
	 */
	public void removeItem(Item item){
		this.items.remove(item);
	}
	
}
