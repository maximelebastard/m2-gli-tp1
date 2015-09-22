package test;

import static org.junit.Assert.*;

import test.TestingObserver;

import model.Item;
import model.ItemSetAdapter;

import org.junit.Test;

/**
 * @author maxime
 *
 */
public class TestModel {
	
	@Test
	public void ItemSetAdapter_observable()
	{
		Item itemJava = new Item("Java", "Java language", 30);
		
		ItemSetAdapter itemsetDev = new ItemSetAdapter("Languages");
		
		TestingObserver testObserver = new TestingObserver();
		itemsetDev.addObserver(testObserver);
		itemsetDev.addItem(itemJava);
		
		assertEquals(1, testObserver.getObservables().size());
	}

}
