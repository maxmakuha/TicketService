package client.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.entities.Route;

@SuppressWarnings("serial")
public class RouteTable extends AbstractTableModel{

	private List<Route> allRoutes;
	private String[] columnNames = {"Номер","Номер автобуса","Довжина маршруту","Пункт відправлення", "Пункт призначення"};
	
	public RouteTable(List<Route> list) {
		allRoutes = list;
	}
	
	@Override
	public int getRowCount() {
		return allRoutes.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1){
		case 0 :
	        return allRoutes.get(arg0).getId();
	    case 1 :
	        return allRoutes.get(arg0).getBusId();
	    case 2 :
	        return allRoutes.get(arg0).getLength();
	    case 3 :
	        return allRoutes.get(arg0).getDeparture();
	    case 4 :
	        return allRoutes.get(arg0).getDestination();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
				return columnNames[column];
	}
}