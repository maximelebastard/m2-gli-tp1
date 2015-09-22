/**
 * 
 */
package controller;

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
