import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MapGUI extends JFrame {
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	private ImageIcon image;

	public MapGUI(WareHouse a) {
		gui(a);
	}

	public void gui(WareHouse a) {
		frame = new JFrame("Map");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLayout(new FlowLayout());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.BLUE);

		button = new JButton("Storage 0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, a.hubs.get(0).statement());
			}
		});
		label = new JLabel("Map");

		panel.add(label);
		frame.add(panel);


		JLabel[] display = new JLabel[a.hubs.size() + 1];
		display[0] = new JLabel(new ImageIcon("images/download.jpg"));
		panel.add(display[0]);
		display[0].setBounds(150, 150, 50, 50);
		display[0].setVisible(true);
		frame.add(display[0]);

		button.setBounds(150, 75, 50, 50);
		button.setVisible(true);
		panel.add(button);
		frame.add(button);

		display[1] = new JLabel(new ImageIcon("images/download.jpg"));
		panel.add(display[1]);
		display[1].setBounds(10 + 100, 250, 50, 50);
		display[1].setVisible(true);
		frame.add(display[1]);

		display[2] = new JLabel(new ImageIcon("images/download.jpg"));
		panel.add(display[2]);
		display[2].setBounds(10 + 200, 250, 50, 50);
		display[2].setVisible(true);
		frame.add(display[2]);

		display[3] = new JLabel(new ImageIcon("images/download.jpg"));
		panel.add(display[3]);
		display[3].setBounds(10 + 300, 250, 50, 50);
		display[3].setVisible(true);
		frame.add(display[3]);

	}

}
