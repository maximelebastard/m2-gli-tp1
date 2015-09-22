package view;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Camembert camembert = new Camembert();
		frame.setSize(800, 600);
		frame.add(camembert);
		frame.setVisible(true);
	}

}
