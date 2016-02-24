package client.forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.entities.Route;

@SuppressWarnings("serial")
public class AddRouteForm extends JFrame {
	
	Route route;
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField busId;
    JTextField lenght;
    JTextField departure;
    JTextField destination;
    JButton addRoute;
    
    int routeId;
    int routeBusId;
    String routeLength;
    String routeDeparture;
    String routeDestination;
    
    public AddRouteForm() {
    	
        this.setSize(700,350);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Додати маршрут");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Номер: "));
        id = new JTextField(10);
        panel.add(id);
        
        panel.add(new JLabel("Номер автобуса: "));
        busId = new JTextField(10);
        panel.add(busId);
        
        panel.add(new JLabel("Довжина: "));
        lenght = new JTextField(10);
        panel.add(lenght);
        
        panel.add(new JLabel("Пункт відправлення: "));
        departure = new JTextField(10);
        panel.add(departure);
        
        panel.add(new JLabel("Пункт призначення: "));
        destination = new JTextField(10);
        panel.add(destination);
        
        addRoute = new JButton("Додати");
        addRoute.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeNotify();
				}
			});
        
        buttonPanel.add(addRoute, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

	public Route getBus() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
}
