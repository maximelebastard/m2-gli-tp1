package view;

import java.awt.Container;
import java.util.List;
import java.util.Observer;

import javax.swing.JComponent;

/**
 * A View interface
 *
 */
public interface IView extends Observer {
	
	/**
	 * Returns an AWT container with the view
	 * @param container
	 */
	void getJComponents(Container container);
}
