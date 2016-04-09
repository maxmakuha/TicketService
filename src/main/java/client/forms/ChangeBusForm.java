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

import server.entities.Bus;

@SuppressWarnings("serial")
public class ChangeBusForm extends JFrame {
	
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
    
    public ChangeBusForm(Bus bus) {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Редагувати інформацію про автобус");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" Номер: "));
        id = new JTextField(10);
        id.setText(""+bus.getId());
        panel.add(id);
        
        panel.add(new JLabel(" Марка: "));
        mark = new JTextField(10);
        mark.setText(bus.getMark());
        panel.add(mark);
        
        panel.add(new JLabel(" Власник: "));
        owner = new JTextField(10);
        owner.setText(bus.getOwner());
        panel.add(owner);
        
        panel.add(new JLabel(" Клас: "));
        clas = new JTextField(10);
        clas.setText(bus.getClas());
        panel.add(clas);
        
        panel.add(new JLabel(" Кількість місць: "));
        placesAmount = new JTextField(10);
        placesAmount.setText(""+bus.getPlacesAmount());
        panel.add(placesAmount);
        
        addBus = new JButton("Редагувати");
        addBus.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
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