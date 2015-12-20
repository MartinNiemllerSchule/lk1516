package info.baethge.lk1516.huffman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * zeigt ein Bild an, Panel in einem Tab
 */
public class GvPicture extends JPanel {
	private BufferedImage bi;
	public GvPicture(BufferedImage bufferedImage) {
		bi = bufferedImage;
		Dimension dimension = new Dimension(bi.getWidth(), bi.getHeight());
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setSize(dimension);
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(bi,0,0,null);
	}

	/**
	 * speichert das Bild im data-Ordner unter dem Datum
	 */
	protected void saveImage() {
		File file = new File("data/"  + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date()) + ".png");
		try {
			ImageIO.write(bi, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
