package model;

/**
 * A graph item
 * 
 * @author maxime
 *
 */
public class Item {
	/**
	 * @var title The item title
	 */
	private String title;
	
	/**
	 * @var description The item description
	 */
	private String description;
	
	/**
	 * @var number The item number
	 */
	private Integer number;
	
	public Item(){
		
	}
	
	public Item(String title, String description, Integer number) {
		super();
		this.title = title;
		this.description = description;
		this.number = number;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
