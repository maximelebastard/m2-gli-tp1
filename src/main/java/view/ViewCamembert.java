package view;

import javax.swing.JComponent;

public class ViewCamembert implements IView {

	public JComponent getJComponent() {
		return new Camembert();
	}

}
