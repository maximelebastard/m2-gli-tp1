/**
 * 
 */
package controller;

import view.IView;


/**
 * @author maxime
 *
 * Interface that defines a controller of this app
 */
public interface IController {
	
	/**
	 * Returns the view of the controller
	 * 
	 * @return IView The view
	 */
	public IView getView();
}
