import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by frank on 02.11.15.
 */
public class Hauptfenster extends JFrame {
	private JPanel panel1;
	private JTextField parameter;
	private JLabel ergebnis;

	public Hauptfenster() {
		parameter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					Byte para = Byte.decode(parameter.getText());
					Long faku = fak(para);
					ergebnis.setText(String.valueOf(faku));
				} catch (ArithmeticException e) {
					JOptionPane.showInternalConfirmDialog(null, e.getMessage(), "Parameter zu groß.",JOptionPane.OK_OPTION);
				}
			}
		});
	}

	public Long fak(Byte n) throws ArithmeticException {
		if (n>59) {
			throw new ArithmeticException("Die Fakultät kann nur bis 59! berechnet werden.");
		}
		if (n==0) {
			return 1L;
		} else {
			return fak((byte) (n - 1)) * n;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hauptfenster");
		frame.setContentPane(new Hauptfenster().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
