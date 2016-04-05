package client.forms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by vlad on 2/23/16.
 */
@SuppressWarnings("serial")
public class ShowPlacesForm extends JFrame implements ActionListener {

	private JPanel mainPanel;
	private JPanel labelPanel;
	private JPanel busPanel;
	private JPanel buttonsPanel;
	private JLabel mainLabel;
	private int numberOfSeats;

	public ShowPlacesForm(String routeName, int numberOfSeats) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
		this.setTitle("Route panel");

		this.numberOfSeats = numberOfSeats;
		this.mainLabel = new JLabel(routeName);

		this.initPanels();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void initPanels() {
		// init main panel
		this.mainPanel = new JPanel();
		// this.mainPanel.setLayout(new GridLayout(0,1));

		// init panels
		this.labelPanel = new JPanel();
		this.labelPanel.add(this.mainLabel);
		initBus();
		this.buttonsPanel = new JPanel();

		// add panels to main panel
		this.mainPanel.add(labelPanel);
		this.mainPanel.add(busPanel);
		this.mainPanel.add(buttonsPanel);

		this.add(mainPanel);

	}

	private void initBus() {
		GridLayout l = new GridLayout(0, this.numberOfSeats / 2);
		l.setHgap(10);
		l.setVgap(10);

		this.busPanel = new JPanel(l);
		this.busPanel.setBackground(Color.LIGHT_GRAY);
		this.busPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Инициализируем генератор
		Random rnd = new Random(System.currentTimeMillis());
		// Получаем случайное число в диапазоне от min до max (включительно)
		int first = 1 + rnd.nextInt(20);
		int second = 1 + rnd.nextInt(20);
		int third = 1 + rnd.nextInt(20);
		int fourth = 1 + rnd.nextInt(20);
		int fifth = 1 + rnd.nextInt(20);

		for (int i = 0; i < 20; i++) {
			JButton bb = new JButton();
			bb.setSize(30, 30);
			bb.setText("" + (i + 1));
			if (i == first || i == second || i == third || i == fourth || i == fifth) {
				bb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PassangerInformationForm form = new PassangerInformationForm();
						form.setVisible(true);
					}
				});
				bb.setBackground(Color.red);
			} else {
				bb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						AddTicketForm form = new AddTicketForm();
						form.setVisible(true);
					}
				});
				bb.setBackground(Color.green);
			}

			this.busPanel.add(bb);
		}
	}

}