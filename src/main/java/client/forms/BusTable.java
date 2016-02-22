package client.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.entities.Bus;

@SuppressWarnings("serial")
public class BusTable extends AbstractTableModel{

	private List<Bus> allBuses;
	private String[] columnNames = {"Номер","Марка","Власник","Клас","Кількість місць"};
	
	public BusTable(List<Bus> list) {
		allBuses = list;
	}
	
	@Override
	public int getRowCount() {
		return allBuses.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1){
		case 0 :
	        return allBuses.get(arg0).getId();
	    case 1 :
	        return allBuses.get(arg0).getMark();
	    case 2 :
	        return allBuses.get(arg0).getOwner();
	    case 3 :
	        return allBuses.get(arg0).getClas();
	    case 4 :
	        return allBuses.get(arg0).getPlacesAmount();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
				return columnNames[column];
	}
}