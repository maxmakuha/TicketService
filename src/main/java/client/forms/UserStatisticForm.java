package client.forms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import server.entities.Passanger;

public class UserStatisticForm extends JFrame {

	public UserStatisticForm(List<Passanger> passangers) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);

		setTitle("Пасажири за останній місяць");
		
		JTable allPassangers = new JTable();
		allPassangers.setModel(new PassangerTable(passangers));
		
		this.add(allPassangers);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}
}