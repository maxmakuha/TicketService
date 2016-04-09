package client.forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import server.entities.Organization;
import server.entities.Passanger;

public class OrgStatisticForm extends JFrame {
	
	public OrgStatisticForm(List<Organization> organizations) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth = 800;
		int sizeHeight = 400;
		int locationX = (screenSize.width - sizeWidth) / 2;
		int locationY = (screenSize.height - sizeHeight) / 2;
		this.setSize(sizeWidth, sizeHeight);
		this.setLocation(locationX, locationY);

		setTitle("Організації за останній місяць");
		
		JTable allOrganizations = new JTable();
		allOrganizations.setModel(new OrganizationTable(organizations));
		
		this.add(allOrganizations);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
	}

}
