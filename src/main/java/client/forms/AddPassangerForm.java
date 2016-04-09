package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.entities.Passanger;

@SuppressWarnings("serial")
public class AddPassangerForm extends JFrame {

	Passanger passanger;
	JPanel panel;
	JPanel buttonPanel;
	JTextField id;
	JTextField pib;
	JTextField passport;
	JTextField organizationId;
	JButton addPassanger;

	public AddPassangerForm() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
		this.setLayout(new GridLayout(2, 2, 2, 2));

		setTitle("Додати клієнта");

		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		panel.add(new JLabel(" Номер: "));
		id = new JTextField(10);
		panel.add(id);

		panel.add(new JLabel(" Прізвище та ім'я: "));
		pib = new JTextField(10);
		panel.add(pib);

		panel.add(new JLabel(" Код паспорту: "));
		passport = new JTextField(10);
		panel.add(passport);

		panel.add(new JLabel(" Номер організації: "));
		organizationId = new JTextField(10);
		panel.add(organizationId);

		addPassanger = new JButton("Додати");
		addPassanger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// removeNotify();
				setVisible(false); // you can't see me!
				dispose(); // Destroy the JFrame object
			}
		});

		buttonPanel.add(addPassanger, BorderLayout.PAGE_END);

		this.add(panel);
		this.add(buttonPanel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
}