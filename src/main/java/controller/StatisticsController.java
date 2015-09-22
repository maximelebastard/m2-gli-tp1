/**
 * 
 */
package controller;

import javax.swing.JFrame;

import view.Camembert;
import view.IView;
import view.ViewCamembert;

/**
 * @author maxime
 *
 */
public class StatisticsController implements IController {

	public IView getView() {
		return new ViewCamembert();
	}

}
