package client.forms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import server.entities.Passage;

public class ChangePassageForm extends JFrame {
	
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
    
    public ChangePassageForm(Passage passage) {
    	
        this.setSize(700,350);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Редагувати інформацію про рейс");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Номер: "));
        id = new JTextField(10);
        id.setText(""+passage.getId());
        panel.add(id);
        
        panel.add(new JLabel("Номер рейсу: "));
        routeId = new JTextField(10);
        routeId.setText(""+passage.getRouteId());
        panel.add(routeId);
        
        panel.add(new JLabel("Час відправлення: "));
        startTime = new JTextField(10);
        startTime.setText(passage.getStartTime());
        panel.add(startTime);
        
        panel.add(new JLabel("Час прибуття: "));
        endTime = new JTextField(10);
        endTime.setText(passage.getEndTime());
        panel.add(endTime);
        
        panel.add(new JLabel("Кількість вільних місць: "));
        freePlaces = new JTextField(10);
        freePlaces.setText(""+passage.getFreePlaces());
        panel.add(freePlaces);
        
//        panel.add(new JLabel("Кількість зупинок: "));
//        amountOfStops = new JTextField(10);
//        panel.add(amountOfStops);
        
        addPassage = new JButton("Редагувати");
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