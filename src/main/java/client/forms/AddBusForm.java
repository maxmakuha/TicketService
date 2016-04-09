package client.forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.entities.Bus;
import client.AdminClient;

@SuppressWarnings("serial")
public class AddBusForm extends JFrame {
	
	Bus bus;
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField mark;
    JTextField owner;
    JTextField clas;
    JTextField placesAmount;
    JButton addBus;
    
    int busId;
    String busMark;
    String busOwner;
    String busClas;
    int busPlacesAmount;
    
    public AddBusForm() {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
    	
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Додати автобус");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" Номер: "));
        id = new JTextField(10);
        panel.add(id);
        
        panel.add(new JLabel(" Марка: "));
        mark = new JTextField(10);
        panel.add(mark);
        
        panel.add(new JLabel(" Власник: "));
        owner = new JTextField(10);
        panel.add(owner);
        
        panel.add(new JLabel(" Клас: "));
        clas = new JTextField(10);
        panel.add(clas);
        
        panel.add(new JLabel(" Кількість місць: "));
        placesAmount = new JTextField(10);
        panel.add(placesAmount);
        
        addBus = new JButton("Додати");
        addBus.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					busId = Integer.parseInt(id.getText());
					busMark = mark.getText();
					busOwner = owner.getText();
					busClas = clas.getText();
					busPlacesAmount = Integer.parseInt(placesAmount.getText());
					bus = new Bus(busId, busMark, busOwner, busClas, busPlacesAmount);
					try {
						AdminClient.tickservice.addBus(bus);
						AdminClient.adminForm.getAllBusesTable().setModel(new BusTable(AdminClient.tickservice.getAllBuses()));
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					removeNotify();
				}
			});
        
        buttonPanel.add(addBus, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
