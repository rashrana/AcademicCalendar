package gui;

import javax.swing.table.AbstractTableModel;

public class calendarTableModel extends AbstractTableModel {
	private DateSelector d;
	public String day[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public calendarTableModel(int year,int month) {
		d=new DateSelector(year,month);
	}
	public String getColumnName(int column) {
		return day[column];
	}

	public int getRowCount() {
		return 6;
	}

	public int getColumnCount() {
		return 7;
	}

	public Object getValueAt(int row, int column) {
		return d.getDate(row, column);
			
	}
	public int getSelectedItem(int row,int column) {
		String date=d.getDate(row, column);
		if(date.length()>2) {
			date=date.replace("99", "");
		}
		return Integer.parseInt(date);
	}

}
