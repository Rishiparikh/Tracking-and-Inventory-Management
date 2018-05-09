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

public class MapGUI extends JFrame {
//	private JFrame frame;
//	private JPanel panel;
//	private JButton button;
//	private JLabel label;
//	private ImageIcon image;
//	private JButton[] buttons;
//	private JLabel[] display;
//
//	public MapGUI(WareHouse a) throws InterruptedException {
//		gui(a);
//	}
//
//	public void gui(WareHouse a) throws InterruptedException {
//		frame = new JFrame("Map");
//		frame.setVisible(true);
//		frame.setSize(1000, 1000);
//		frame.setLayout(new FlowLayout());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        try {
//            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/download2.png")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        frame.pack();
//        frame.setVisible(true);
//		panel = new JPanel();
//		panel.setBackground(Color.BLUE);
//
//		button = new JButton("Main");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, a.statement());
//			}
//		});
//
//		label = new JLabel("Map");
//
//		panel.add(label);
//		frame.add(panel);
//
//		display = new JLabel[a.hubs.size() + 1];
//		buttons = new JButton[a.hubs.size()];
//		display[0] = new JLabel(new ImageIcon("images/red.png"));
//		panel.add(display[0]);
//		display[0].setBounds(a.x, a.y, 52, 52);
//		display[0].setVisible(true);
//		frame.add(display[0]);
//
//		button.setBounds(a.x - 15, a.y - 20, 75, 20);
//		button.setVisible(true);
//		panel.add(button);
//		frame.add(button);
//
//		for (int i = 1; i < a.hubs.size() + 1; i++) {
//			int j = i-1;
//			buttons[i - 1] = new JButton("" + i);
//			buttons[i - 1].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(null, a.hubs.get(j).statement());
//				}
//			});
//
//			if (a.hubs.get(i - 1).redAlert) {
//				display[i] = new JLabel(new ImageIcon("images/red.png"));
//
//			} else if (a.hubs.get(i - 1).yellowAlert) {
//				display[i] = new JLabel(new ImageIcon("images/yellow.png"));
//
//			} else {
//				display[i] = new JLabel(new ImageIcon("images/green.png"));
//			}
//			panel.add(display[i]);
//			display[i].setBounds(a.hubs.get(i - 1).x, a.hubs.get(i - 1).y, 50, 50);
//			display[i].setVisible(true);
//			frame.add(display[i]);
//			buttons[i - 1].setBounds(a.hubs.get(i - 1).x - 15, a.hubs.get(i - 1).y - 30, 75, 20);
//			buttons[i - 1].setVisible(true);
//			panel.add(buttons[i - 1]);
//			frame.add(buttons[i - 1]);
//		}
//
//	}
//
//	public void update(WareHouse a) {
//		a.checkRedAlert();
//		a.checkYellowAlert();
//		if(a.redAlert){
//			display[0].setIcon(new ImageIcon("images/red.png"));
//			System.out.println("red");
//		}
//		else if(a.yellowAlert){
//			display[0].setIcon(new ImageIcon("images/yellow.png"));
//			System.out.println("y");
//		}
//		else {
//			System.out.println("g");
//			display[0].setIcon(new ImageIcon("images/green.png"));
//		}
//		
//		for(int i = 1; i < a.hubs.size() + 1; i++) {
//			a.hubs.get(i-1).checkRedAlert();
//			a.hubs.get(i-1).checkYellowAlert();
//			
//		if(a.hubs.get(i - 1).redAlert){
//			display[i].setIcon(new ImageIcon("images/red.png"));
//
//		}
//		else if(a.hubs.get(i-1).yellowAlert){
//			display[i].setIcon(new ImageIcon("images/yellow.png"));
//
//		}
//		else {
//			display[i].setIcon(new ImageIcon("images/green.png"));
//		}
//	}
//		
//	}
//	public void transport(WareHouse a, Item b, int c, Storage d) {
//		a.transportItem(b, c, d);
//		
//	}
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel label;
	private ImageIcon image;
	private JButton[] buttons;
	private JLabel[] display;
	private JPanel panel1;
	private JLabel img;
	public MapGUI(WareHouse a) throws InterruptedException {
		gui(a);
	}

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
//		frame.add(panel);

		display = new JLabel[a.hubs.size() + 1];
		buttons = new JButton[a.hubs.size()];
		display[0] = new JLabel(new ImageIcon("images/red.png"));
		panel.add(display[0]);
		display[0].setBounds(a.x, a.y, 52, 52);
		display[0].setVisible(true);
		frame.add(display[0]);

		button.setBounds(a.x - 15, a.y - 20, 75, 20);
		button.setVisible(true);
//		panel.add(button);
		frame.add(button);

		for (int i = 1; i < a.hubs.size() + 1; i++) {
			int j = i-1;
			buttons[i - 1] = new JButton("" + i);
			buttons[i - 1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, a.hubs.get(j).statement());
				}
			});

			if (a.hubs.get(i - 1).redAlert) {
				display[i] = new JLabel(new ImageIcon("images/red.png"));

			} else if (a.hubs.get(i - 1).yellowAlert) {
				display[i] = new JLabel(new ImageIcon("images/yellow.png"));

			} else {
				display[i] = new JLabel(new ImageIcon("images/green.png"));
			}
			panel.add(display[i]);
			display[i].setBounds(a.hubs.get(i - 1).x, a.hubs.get(i - 1).y, 50, 50);
			display[i].setVisible(true);
			frame.add(display[i]);
			buttons[i - 1].setBounds(a.hubs.get(i - 1).x - 15, a.hubs.get(i - 1).y - 30, 75, 20);
			buttons[i - 1].setVisible(true);
//			panel.add(buttons[i - 1]);
			frame.add(buttons[i - 1]);
			 img = new JLabel(new ImageIcon("images/transport.png"));
			panel.add(img);
			frame.add(img);
		}
	}

	public void update(WareHouse a) {
		a.checkRedAlert();
		a.checkYellowAlert();
		if(a.redAlert){
			display[0].setIcon(new ImageIcon("images/red.png"));
			System.out.println("red");
		}
		else if(a.yellowAlert){
			display[0].setIcon(new ImageIcon("images/yellow.png"));
			System.out.println("y");
		}
		else {
			System.out.println("g");
			display[0].setIcon(new ImageIcon("images/green.png"));
		}
		
		for(int i = 1; i < a.hubs.size() + 1; i++) {
			a.hubs.get(i-1).checkRedAlert();
			a.hubs.get(i-1).checkYellowAlert();
			
		if(a.hubs.get(i - 1).redAlert){
			display[i].setIcon(new ImageIcon("images/red.png"));

		}
		else if(a.hubs.get(i-1).yellowAlert){
			display[i].setIcon(new ImageIcon("images/yellow.png"));

		}
		else {
			display[i].setIcon(new ImageIcon("images/green.png"));
		}
	}
		
	}
	public void transport(WareHouse a, Item b, int c, Storage d) throws InterruptedException {
		a.transportItem(b, c, d);

		for(int i = 5; i < 17; i++) {
		img.setBounds(a.x + i * getDirectionX(a,d), a.y + i * getDirectionY(a,d), 92, 55);
		img.setVisible(true);
		TimeUnit.SECONDS.sleep(1);

		}
		img.setVisible(false);
		
	}
	public int getDirectionX(Storage a, Storage b) {
		return (b.x - a.x)/20;
	}
	public int getDirectionY(Storage a, Storage b) {
		return (b.y-a.y)/20;
	}
}
