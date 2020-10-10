package gui;

import java.sql.Date;
import java.util.Calendar;


public class nonCalendar {
	private String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String[] week= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	private final  int curday,curmonth,curyear;
	private int leapyear=0,noOfDays=0,yearCount=0;
	private int startMonth,weekday;
	private int daysInMonth[]= new int[12];
	private int choosenyear,choosenmonth;
	
	public int getChoosenmonth() {
		return this.choosenmonth;
	}
	public int getChoosenyear() {
		return this.choosenyear;
	}
	public int getCurday() {
		return this.curday;
	}
	public int getCurmonth() {
		return this.curmonth;
	}
	public int getCuryear() {
		return this.curyear;
	}
	public int getStartMonth() {
		return this.startMonth;
	}
	
	public int getDaysInMonth(int year,int month) {
		if(year%4==0) daysInMonth[1]=29;
		return daysInMonth[month-1];
	}
	public nonCalendar() {
		 
		daysInMonth[0]=31;
		daysInMonth[1]=28;
		daysInMonth[2]=31;
		daysInMonth[3]=30;
		daysInMonth[4]=31;
		daysInMonth[5]=30;
		daysInMonth[6]=31;
		daysInMonth[7]=31;
		daysInMonth[8]=30;
		daysInMonth[9]=31;
		daysInMonth[10]=30;
		daysInMonth[11]=31;
		
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		curyear=c.get(Calendar.YEAR);
		curmonth=c.get(Calendar.MONTH)+1;
		curday=c.get(Calendar.DAY_OF_MONTH);
		choosenyear=curyear;
		choosenmonth=curmonth;
		
		if(curyear%4==0) daysInMonth[1]=29;
		
		if(curyear>2011) {
			
			yearCount= curyear-2011;
			for(int i=1;i<curmonth;i++) noOfDays += daysInMonth[i-1];
			for(int i=2011;i<curyear;i++) {
				if(i%4==0) leapyear++;
			}
			noOfDays+= (yearCount*365) + leapyear;
			startMonth= noOfDays%7;
			if(startMonth==0)startMonth=7;
		}
		else {
			yearCount= 2011-curyear-1;
			for(int i=12;i>=curmonth;i--) noOfDays += daysInMonth[i-1];
			for(int i=2010;i>curyear;i--) {
				if(i%4==0) leapyear++;
			}
			noOfDays += (yearCount*365) + leapyear;
			startMonth= 7-(noOfDays%7);
		}
	}
	public nonCalendar(int year,int month) {
		
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		curyear=c.get(Calendar.YEAR);
		curmonth=c.get(Calendar.MONTH)+1;
		curday=c.get(Calendar.DAY_OF_MONTH);
		choosenyear=year;
		choosenmonth=month;
		
		daysInMonth[0]=31;
		daysInMonth[1]=28;
		daysInMonth[2]=31;
		daysInMonth[3]=30;
		daysInMonth[4]=31;
		daysInMonth[5]=30;
		daysInMonth[6]=31;
		daysInMonth[7]=31;
		daysInMonth[8]=30;
		daysInMonth[9]=31;
		daysInMonth[10]=30;
		daysInMonth[11]=31;
		
		
		
		if(choosenyear%4==0) daysInMonth[1]=29;
		
		if(choosenyear>2011) {
			
			yearCount= choosenyear-2011;
			for(int i=1;i<choosenmonth;i++) noOfDays += daysInMonth[i-1];
			for(int i=2011;i<choosenyear;i++) {
				if(i%4==0) leapyear++;
			}
			noOfDays+= (yearCount*365) + leapyear;
			startMonth= noOfDays%7;
			if(startMonth==0)startMonth=7;
		}
		else {
			yearCount= 2011-choosenyear-1;
			for(int i=12;i>choosenmonth;i--) 
				noOfDays += daysInMonth[i-1];
			for(int i=2010;i>choosenyear;i--) {
				if(i%4==0) leapyear++;
			}
			noOfDays += (yearCount*365) + leapyear;
			startMonth= 7-(noOfDays%7);
		}
		
	}
	public void display() {
		System.out.println("\t\t\t*******"+months[curmonth-1]+","+curyear+"********");
		int weekday=startMonth;
		for(int i=0;i<7;i++) System.out.print("\t"+week[i]);
		System.out.println();
		for(int i=1;i<startMonth;i++) System.out.print("\t");
		for(int i=1;i<=daysInMonth[curmonth-1];i++) {
			if(weekday%7==0) {
				weekday=0;
				System.out.println("\t"+i);
				if(i==curday) System.out.println("\t"+i+"*");
			}
			else {
				System.out.print("\t"+i);
				if(i==curday) System.out.print("\t"+i+"*");
			}
			weekday++;
		}
	}
	/*public static void main(String args[]) {
		
		
		
		nonCalendar a=new nonCalendar();
		
		System.out.println(a.curyear+" "+(a.curmonth)+" "+a.curday+" "+a.startMonth);
		a.display();
		
		
		
		
		
		
		
	}*/
}

