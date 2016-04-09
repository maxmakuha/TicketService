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

@SuppressWarnings("serial")
public class ClassPriceForm extends JFrame {
	
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField busId;
    JTextField length;
    JTextField departure;
    JTextField destination;
    JButton addRoute;
    
    int routeId;
    int routeBusId;
    String routeLength;
    String routeDeparture;
    String routeDestination;
    
    public ClassPriceForm() {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Класи автобусів");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" Ціна проїзду (грн) відстані 1 км:"));
        panel.add(new JLabel(""));
        panel.add(new JLabel("  Клас А: "));
        id = new JTextField(10);
        id.setText("100");
        panel.add(id);
        
        panel.add(new JLabel("  Клас B: "));
        busId = new JTextField(10);
        busId.setText("80");
        panel.add(busId);
        
        panel.add(new JLabel("  Клас С: "));
        length = new JTextField(10);
        length.setText("60");
        panel.add(length);
        
        panel.add(new JLabel("  Клас D: "));
        departure = new JTextField(10);
        departure.setText("40");
        panel.add(departure);
        
        addRoute = new JButton("Редагувати");
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
}