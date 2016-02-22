package client.forms;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.entities.Passage;

@SuppressWarnings("serial")
public class PassageTable extends AbstractTableModel{

	private List<Passage> allPassages;
	private String[] columnNames = {"Номер","Номер маршруту","Час відправлення","Час прибуття","Кількість вільних місць", "Кількість зупинок"};
	
	public PassageTable(List<Passage> list) {
		allPassages = list;
	}
	
	@Override
	public int getRowCount() {
		return allPassages.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1){
		case 0 :
	        return allPassages.get(arg0).getId();
	    case 1 :
	        return allPassages.get(arg0).getRouteId();
	    case 2 :
	        return allPassages.get(arg0).getStartTime();
	    case 3 :
	        return allPassages.get(arg0).getEndTime();
	    case 4 :
	        return allPassages.get(arg0).getFreePlaces();
	    case 5 :
	        return allPassages.get(arg0).getStopsAmount();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
				return columnNames[column];
	}
}