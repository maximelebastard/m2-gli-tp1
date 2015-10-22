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
public class ItemSet {

	/**
	 * @var title The itemset title
	 */
	private String title;

	/**
	 * @var items Items of the itemset
	 */
	private List<Item> items = new ArrayList<Item>();

	public ItemSet() {
		super();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
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
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * Adds a new item in the set
	 * 
	 * @param item
	 *            The item to add
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}

	/**
	 * Gets the sum of all the numbers value of item set items
	 * 
	 * @return The sum of the numbers
	 */
	public Integer getItemsNumberSum() {
		List<Item> items = getItems();

		int sum = 0;

		for (Item i : items) {
			// if the user have entered a value for this item
			if (i.getNumber() != null && i.getTitle()!=null) {
				sum += (int) i.getNumber();
			}
		}

		return sum;
	}
}
