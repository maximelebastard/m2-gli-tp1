package view;

import javax.swing.JComponent;
import view.jcomponent.Camembert;


public class ViewCamembert implements IView {

	public JComponent getJComponent() {
		return new Camembert();
	}

}
