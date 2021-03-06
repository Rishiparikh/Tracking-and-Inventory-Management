import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * @author Rishi Parikh
 * MapGUI class which extends JFrame
 * contains the layout for our warehouses and storage centers
 *
 */
public class MapGUI extends JFrame {
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	private ImageIcon image;
	private JButton[] buttons;
	private JLabel[] display;
	private JPanel panel1;
	private JLabel img;
	private JButton buttonimg;
	private JLabel[] details;
	/**
	 * Constructor for MapGUI class
	 * @param a = object of type Warehouse. Called in gui method
	 * @throws InterruptedException
	 */
	public MapGUI(WareHouse a) throws InterruptedException {
		gui(a);
	}
	/**
	 * gui method
	 * creates the jFrame map for our shipping to take place
	 * @param a = object of type Warehouse to call the frame
	 * @throws InterruptedException
	 */
	public void gui(WareHouse a) throws InterruptedException {
		frame = new JFrame("Map");
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/download2.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.pack();
		frame.setVisible(true);

	}
	/**
	 * Method that adds items and storage center into our JFrame map
	 * Also creates all the images and buttons
	 * @param a = object of type Warehouse to call the frame
	 */
	public void create(WareHouse a) {
		panel = new JPanel();
		panel.setBackground(Color.BLUE);

		button = new JButton("Main");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, a.statement());
			}
		});

		label = new JLabel("Map");

		panel.add(label);
		display = new JLabel[a.hubs().size() + 1];
		buttons = new JButton[a.hubs().size()];
		details = new JLabel[a.hubs().size() + 1];
		details[0] = new JLabel(a.statement());
		panel.add(details[0]);
		frame.add(panel);
		frame.add(details[0]);
		display[0] = new JLabel(new ImageIcon("images/red.png"));
		panel.add(display[0]);
		display[0].setBounds(a.x(), a.y(), 52, 52);
		display[0].setVisible(true);
		frame.add(display[0]);

		button.setBounds(a.x() - 15, a.y() - 20, 75, 20);
		button.setVisible(true);
		frame.add(button);

		for (int i = 1; i < a.hubs().size() + 1; i++) {
			details[i] = new JLabel("Storage # " + i + " " + a.hubs().get(i-1).statement());
			panel.add(details[i]);
			frame.add(panel);
			frame.add(details[i]);
			details[i].setVisible(true);
			details[i].setBounds(10, 475 + 20 * i, 400, 20);
			int j = i - 1;
			buttons[i - 1] = new JButton("" + i);
			buttons[i - 1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, a.hubs().get(j).statement());
				}
			});

			if (a.hubs().get(i - 1).redAlert()) {
				display[i] = new JLabel(new ImageIcon("images/red.png"));

			} else if (a.hubs().get(i - 1).yellowAlert()) {
				display[i] = new JLabel(new ImageIcon("images/yellow.png"));

			} else {
				display[i] = new JLabel(new ImageIcon("images/green.png"));
			}
			panel.add(display[i]);
			display[i].setBounds(a.hubs().get(i - 1).x(), a.hubs().get(i - 1).y(), 50, 50);
			display[i].setVisible(true);
			frame.add(display[i]);
			buttons[i - 1].setBounds(a.hubs().get(i - 1).x() - 15, a.hubs().get(i - 1).y() - 30, 75, 20);
			buttons[i - 1].setVisible(true);
			// panel.add(buttons[i - 1]);
			frame.add(buttons[i - 1]);
			img = new JLabel(new ImageIcon("images/transport.png"));
			panel.add(img);
			frame.add(img);
			buttonimg = new JButton("Ship");
			frame.add(buttonimg);
		}
	}
	/**
	 * Method to update the storages after an item has been shipped
	 * @param a = object of type Warehouse to call the frame
	 */
	public void update(WareHouse a) {
		details[0].setText(a.statement());;
		details[0].setVisible(true);
		details[0].setBounds(10, 475, 400, 20);
		for (int i = 1; i < a.hubs().size() + 1; i++) {
			details[i].setText("Storage # " + i + " " + a.hubs().get(i-1).statement());;
			panel.add(details[i]);
			frame.add(panel);
			frame.add(details[i]);
			details[i].setVisible(true);
			details[i].setBounds(10, 475 + 20 * i, 400, 20);
		}
		a.checkRedAlert();
		a.checkYellowAlert();
		if (a.redAlert()) {
			display[0].setIcon(new ImageIcon("images/red.png"));
		} else if (a.yellowAlert()) {
			display[0].setIcon(new ImageIcon("images/yellow.png"));
		} else {
			display[0].setIcon(new ImageIcon("images/green.png"));
		}

		for (int i = 1; i < a.hubs().size() + 1; i++) {
			a.hubs().get(i - 1).checkRedAlert();
			a.hubs().get(i - 1).checkYellowAlert();

			if (a.hubs().get(i - 1).redAlert()) {
				display[i].setIcon(new ImageIcon("images/red.png"));

			} else if (a.hubs().get(i - 1).yellowAlert()) {
				display[i].setIcon(new ImageIcon("images/yellow.png"));

			} else {
				display[i].setIcon(new ImageIcon("images/green.png"));
			}
		}

	}
	/**
	 * Method to transport an item from the Warehouse to a storage center
	 * @param a = object of type Warehouse
	 * @param b = Item to be shipped
	 * @param c = quantity of the item that is being shipped
	 * @param d = Storage center to be shipped
	 * @throws InterruptedException
	 */
	public void transport(WareHouse a, Item b, int c, Storage d) throws InterruptedException {
		buttonimg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Shipping " + c + " " + b.getName());
			}
		});
		buttonimg.setVisible(true);
		for (int i = 3; i < 17; i+=2) {
			img.setBounds(a.x() + i * getDirectionX(a, d), a.y() + i * getDirectionY(a, d), 92, 55);
			buttonimg.setBounds(a.x() + i * getDirectionX(a, d), a.y() - 20 + i * getDirectionY(a, d), 100, 20);
			img.setVisible(true);
			TimeUnit.SECONDS.sleep(1);

		}
		img.setVisible(false);
		buttonimg.setVisible(false);
		a.transportItem(b, c, d);
	}
	/**
	 * Method to get the distance between two storage center in the X direction 
	 * @param a = storage center 1
	 * @param b = storage center 2
	 * @return the distance in the x direction
	 */
	public int getDirectionX(Storage a, Storage b) {
		return (b.x() - a.x()) / 20;
	}
	/**
	 * Method to get the distance between two storage center in the Y direction 
	 * @param a = storage center 1
	 * @param b = storage center 2
	 * @return the distance in the y direction
	 */
	public int getDirectionY(Storage a, Storage b) {
		return (b.y() - a.y()) / 20;
	}
}
