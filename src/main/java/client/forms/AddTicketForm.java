package client.forms;

import server.entities.Ticket;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AddTicketForm extends JFrame {

	Ticket ticket;
    JPanel panel;
    JPanel buttonPanel;
    JTextField pib;
    JTextField passport;

    JButton addTicket;

//    int ticketId;
//    String firstName;
//    String lastName;

    public AddTicketForm() {
    	//TODO

    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2));

        setTitle("Бронювати");


        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" ПІБ: "));
        pib = new JTextField(5);
        panel.add(pib);
        
        panel.add(new JLabel(" Паспорт: "));
        passport = new JTextField(5);
        panel.add(passport);

        addTicket = new JButton("Додати");
        addTicket.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
                    //TODO
				}
        });
        
        buttonPanel.add(addTicket, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

}
