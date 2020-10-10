package gui;

public class DateSelector {
	private nonCalendar cal;
	private String data[][]=new String[6][7];
	public DateSelector(int year,int month) {
		cal=new nonCalendar(year,month);
		int start=cal.getStartMonth();
		
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				data[i][j]=new String("");
				
			}
		}
		int i=0;
		int count=1;
		int noofdays=cal.getDaysInMonth(year,month);
		for(int j=start;j<=noofdays+start-1;j++) {
			int x=j%7;
			if (x==0) {
				x=7;	
			}
			if(j!=1 && x==1) i++;
			if(year==cal.getCuryear() && month==cal.getCurmonth() && count==cal.getCurday()) data[i][x-1]=new String(count+"99");
			else data[i][x-1]=new String(count+"");
			count++;
		}
	}
	public String getDate(int row,int column) {
		return data[row][column];
	}
}
