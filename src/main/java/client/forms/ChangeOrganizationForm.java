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

import server.entities.Organization;
import server.entities.Passanger;

@SuppressWarnings("serial")
public class ChangeOrganizationForm extends JFrame {
	
	Passanger passanger;
    JPanel panel;
    JPanel buttonPanel;
    JTextField id;
    JTextField name;
    JButton addOrganization;
    
    public ChangeOrganizationForm(Organization organization) {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Редагувати інформацію про організацію");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel(" Номер: "));
        id = new JTextField(10);
        id.setText(""+organization.getId());
        panel.add(id);
        
        panel.add(new JLabel(" Назва: "));
        name = new JTextField(10);
        name.setText(organization.getName());
        panel.add(name);
        
        addOrganization = new JButton("Редагувати");
        addOrganization.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					removeNotify();
				}
			});
        
        buttonPanel.add(addOrganization, BorderLayout.PAGE_END);
        
        this.add(panel);
        this.add(buttonPanel);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }
}