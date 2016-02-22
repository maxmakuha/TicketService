package client.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.entities.Organization;

@SuppressWarnings("serial")
public class OrganizationTable extends AbstractTableModel{

	private List<Organization> allOrganizations;
	private String[] columnNames = {"Номер","Назва"};
	
	public OrganizationTable(List<Organization> list) {
		allOrganizations = list;
	}
	
	@Override
	public int getRowCount() {
		return allOrganizations.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1){
		case 0 :
	        return allOrganizations.get(arg0).getId();
	    case 1 :
	        return allOrganizations.get(arg0).getName();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
				return columnNames[column];
	}
}