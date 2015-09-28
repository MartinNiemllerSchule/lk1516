package info.baethge.lk1516.kochkurve;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new Kurve(5);
		frame.setTitle("Kochkurve");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(820, 300));
		frame.setLocation(new Point(50, 50));
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);
	}

}
