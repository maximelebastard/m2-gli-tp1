import javax.swing.JFrame;

import view.Camembert;

import controller.IController;
import controller.StatisticsController;

/**
 * 
 */

/**
 * @author maxime
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IController appController = new StatisticsController();

		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.add(appController.getView().getJComponent());
		frame.setVisible(true);

	}

}
