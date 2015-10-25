/**
 * 
 */
package controller;

import model.IItemListAdapter;
import model.ItemSetAdapter;
import view.IView;
import view.ViewCamembert;

/**
 * @author maxime
 *
 * Controller of the statistics screen
 */
public class StatisticsController implements IController {
	
	private IItemListAdapter model;
	private IView view;
	
	/**
	 * Initializes the controller with the view and the model
	 */
	public StatisticsController() {
		model = new ItemSetAdapter();
		view = new ViewCamembert(model);
		model.addObserver(view);
	}

	/**
	 * Returns the view
	 * 
	 * @return IView The view
	 */
	public IView getView() {
		return view;
	}

}
