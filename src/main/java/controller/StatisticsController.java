/**
 * 
 */
package controller;

import javax.swing.JComponent;

import view.IView;
import view.ViewCamembert;
import view.jcomponent.Camembert;

/**
 * @author maxime
 *
 */
public class StatisticsController implements IController {

	public JComponent getView() {
		return new Camembert();
	}

}
