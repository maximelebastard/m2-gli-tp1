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


public class ViewCamembert implements IView,Observer {

	private IItemListAdapter model;
	private Camembert camembert;
	
	public ViewCamembert(IItemListAdapter pModel){
		model=pModel;
		camembert=new Camembert(model);
	}
	
	public void getJComponents(Container container) {
		container.add(camembert,BorderLayout.CENTER);
		container.add(new TableItem(model),BorderLayout.EAST);
	}

	public void update(Observable o, Object arg) {
		camembert.repaint();
	}

}

