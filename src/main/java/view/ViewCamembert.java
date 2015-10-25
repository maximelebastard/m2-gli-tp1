package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import model.IItemListAdapter;
import model.ItemSetAdapter;
import view.jcomponent.Camembert;
import view.jcomponent.TableItem;

/**
 * The camembert view
 * @author romain
 *
 */
public class ViewCamembert implements IView,Observer {

	/**
	 * The model that the view observes
	 */
	private IItemListAdapter model;
	
	/**
	 * The view component
	 */
	private Camembert camembert;
	
	/**
	 * Constructs the view
	 * @param pModel The model
	 */
	public ViewCamembert(IItemListAdapter pModel){
		model=pModel;
		camembert=new Camembert(model);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void getJComponents(Container container) {
		container.add(camembert,BorderLayout.CENTER);
		container.add(new TableItem(model),BorderLayout.EAST);
	}

	/**
	 * Update is called when an observable changes
	 * @param o Observable The observable that changed
	 * @param arg Object The arguments that the observable sent
	 */
	public void update(Observable o, Object arg) {
		camembert.repaint();
	}

}

