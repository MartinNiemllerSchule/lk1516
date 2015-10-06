package info.baethge.lk1516.geometrischeObjekte;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new Main();
		frame.setTitle("Zeichnung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(800, 300));
		frame.setSize(new Dimension(800, 300));
		frame.setLocation(new Point(50, 50));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		try {
			Figur k1 = new Kreis(80, new Point(100, 100));
			k1.paint(g);
			System.out.println("k1 ist ein " + k1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}