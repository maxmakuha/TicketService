package client.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.entities.Passanger;

@SuppressWarnings("serial")
public class PassangerTable extends AbstractTableModel{

	private List<Passanger> allPassangers;
	private String[] columnNames = {"Номер","ПІБ","Код паспорту","Номер організації"};
	
	public PassangerTable(List<Passanger> list) {
		allPassangers = list;
	}
	
	@Override
	public int getRowCount() {
		return allPassangers.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1){
		case 0 :
	        return allPassangers.get(arg0).getId();
	    case 1 :
	        return allPassangers.get(arg0).getPib();
	    case 2 :
	        return allPassangers.get(arg0).getPassport();
	    case 3 :
	        return allPassangers.get(arg0).getOrganizationId();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
				return columnNames[column];
	}
}