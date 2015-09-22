/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import model.Item;
import model.ItemSet;
import model.ItemSetAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author maxime
 *
 */
public class TestModel {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void ItemSetAdapter_observable()
	{
		Item itemJava = new Item("Java", "Java language", 30);
		Item itemPhp = new Item("Php", "Php web language", 40);
		Item itemC = new Item("C","C roots language",30);		
		
		ItemSetAdapter itemsetDev = new ItemSetAdapter("Languages");
		
		TestingObserver testObserver = new TestingObserver();
		itemsetDev.addObserver(testObserver);
		itemsetDev.addItem(itemJava);
		
		assertEquals(1, testObserver.getObservables().size());
	}

}
