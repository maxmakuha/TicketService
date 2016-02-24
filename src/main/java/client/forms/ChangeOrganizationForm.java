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
    	
        this.setSize(700,350);
        this.setLayout(new GridLayout(2, 2, 2, 2));

        setTitle("Редагувати інформацію про організацію");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Номер: "));
        id = new JTextField(10);
        id.setText(""+organization.getId());
        panel.add(id);
        
        panel.add(new JLabel("Назва: "));
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