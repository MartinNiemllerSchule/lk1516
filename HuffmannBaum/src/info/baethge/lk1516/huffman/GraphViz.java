package info.baethge.lk1516.huffman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Das Fenster, in dem die unterschiedlichen Zustände des Graphen angezeigt werden
 * Created by frank on 12.12.15.
 */
public class GraphViz extends JFrame implements KeyListener {
	private JTabbedPane tabbedPane;
	private Dimension dimension;

	protected GraphViz() {
		setTitle("GraphViz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		dimension = new Dimension(20, 200);
		tabbedPane = new JTabbedPane();
		setContentPane(tabbedPane);

		setPreferredSize(dimension);
		setSize(dimension);
		setLocation(20, 20);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);
	}

	/**
	 * hängt das Bild als nächsten Tab an tabbedPane an, dazu wird ein JPanel: GvPicture erzeugt, dass das Bild dann auch
	 * anzeigt
	 * @param bufferedImage - anzuzeigendes Bild
	 */
	protected void addPic(BufferedImage bufferedImage) {
		if (bufferedImage != null) {
			JPanel gvp = new GvPicture(bufferedImage);
			dimension.setSize(
					new Dimension(
							(int) Math.max(dimension.getWidth(), gvp.getWidth() + 10),
							(int) Math.max(dimension.getHeight(), gvp.getHeight() + 40)
					));
			setSize(dimension);
			Integer nr = tabbedPane.getTabCount() + 1;
			tabbedPane.addTab(nr.toString(), gvp);
		}
	}

	/**
	 * speichert die Bilder aller Tabs, wenn Strg-S gedrückt wird (geht momentan noch nicht)
	 */
	protected void saveAllTabs() {
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			GvPicture gvPicture = (GvPicture) tabbedPane.getComponentAt(i);
			gvPicture.saveImage();
		}
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		System.out.println("Key: " + keyEvent.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		System.out.println("Key: " + keyEvent.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		System.out.println("Key: " + keyEvent.getKeyChar());
		if((keyEvent.getKeyCode() == KeyEvent.VK_S) && ((keyEvent.getModifiers() & keyEvent.CTRL_MASK) != 0)) {
			saveAllTabs();
		}
	}
}
