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
 */
public class StatisticsController implements IController {
	
	public IView getView() {
		IItemListAdapter model = new ItemSetAdapter();
		ViewCamembert view = new ViewCamembert(model);
		model.addObserver(view);
		return view;
	}

}
