package app;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.IController;
import controller.StatisticsController;

/**
 * @author maxime
 *
 */
public class Application {

	public static void main(String[] args) {
		
		IController appController = new StatisticsController();

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(1200, 700);
		// here we add all components of the view 
		appController.getView().getJComponents(frame.getContentPane());
		
		frame.setVisible(true);
	}

}
