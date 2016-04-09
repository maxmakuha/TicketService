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

import server.entities.Passage;

@SuppressWarnings("serial")
public class AddPassageForm extends JFrame {
	
	Passage passage;
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField routeId;
    JTextField startTime;
    JTextField endTime;
    JTextField freePlaces;
    JTextField amountOfStops;
    JButton addPassage;
    
    public AddPassageForm() {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Додати рейс");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" Номер: "));
        id = new JTextField(10);
        panel.add(id);
        
        panel.add(new JLabel(" Номер рейсу: "));
        routeId = new JTextField(10);
        panel.add(routeId);
        
        panel.add(new JLabel(" Час відправлення: "));
        startTime = new JTextField(10);
        panel.add(startTime);
        
        panel.add(new JLabel(" Час прибуття: "));
        endTime = new JTextField(10);
        panel.add(endTime);
        
        panel.add(new JLabel(" Кількість вільних місць: "));
        freePlaces = new JTextField(10);
        panel.add(freePlaces);
        
//        panel.add(new JLabel("Кількість зупинок: "));
//        amountOfStops = new JTextField(10);
//        panel.add(amountOfStops);
        
        addPassage = new JButton("Додати");
        addPassage.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeNotify();
				}
			});
        
        buttonPanel.add(addPassage, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

	public Passage getBus() {
		return passage;
	}

	public void setRoute(Passage passage) {
		this.passage = passage;
	}
}