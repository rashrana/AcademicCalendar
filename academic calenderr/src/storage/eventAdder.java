package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class eventAdder {
	private String event;
	private String date;
	private String time;
	private String type;
	private String url="jdbc:mysql://localhost:3325/calender";
	private String user="root";
	private String pass="";
	private ResultSet rs;
	private Statement s;
	private PreparedStatement st;

	public String addEvent (String event,String type,String date,String time)  {
		 this.event=event;
		 this.date=date;
		 this.time=time;
		 this.type=type;
		 try {
			 try {
				 Class.forName("com.mysql.jdbc.Driver");
			 }
			 catch(ClassNotFoundException e) { 
				 e.getMessage();
			 }
			 Connection con=DriverManager.getConnection(url,user,pass);
			 PreparedStatement st=con.prepareStatement("insert into events values(?,?,?,?)");
			 st.setString(1,event);
			 st.setString(2,type);
			 st.setString(3,date);
			 st.setString(4, time);
			 st.executeUpdate();
			 st.close();
			 con.close();
			 return "Event Added Successfully! Check Event window to see your Event.";
			  }
	  catch(Exception e){
			return e.getMessage(); 
		 }	
	 }
	
	public String[] getEvent(String fdate,String ldate) {
		String[] eve;
		int i=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,user,pass);
			 String query="Select * from events where Date>=? and Date<? ; ";
			 st=con.prepareStatement(query);
			 st.setString(1, fdate);
			 st.setString(2, ldate);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			 eve=new String[i];
			 i=0;
			 st=con.prepareStatement(query);
			 st.setString(1, fdate);
			 st.setString(2, ldate);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 
				 eve[i++]=rs.getDate(3)+"\t\t"+rs.getTime(4)+"\t\t"+rs.getString(1)+"\t\t"+rs.getString(2);
			 }
			 st.close();
			 con.close();
			 return eve;
		 }
		 catch(Exception e){
			e.printStackTrace();
			eve=new String[0];
			return eve;
		 }
		 finally {
		 }
		
	}
	public String[] getSpecificEvent(String date) {
		String[] eve;
		int i=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,user,pass);
			 String query="Select * from events where Date=? ; ";
			 st=con.prepareStatement(query);
			 st.setString(1, date);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			 eve=new String[i];
			 i=0;
			 st=con.prepareStatement(query);
			 st.setString(1, date);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 
				 eve[i++]=rs.getTime(4)+"\t"+rs.getString(2)+"\t\t"+rs.getString(1);
			 }
			 st.close();
			 con.close();
			 return eve;
		 }
		 catch(Exception e){
			e.printStackTrace();
			eve=new String[0];
			return eve;
		 }
		 finally {
		 }
		
	}
	public String[] getEventOnly(String date) {
		String[] eve;
		int i=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,user,pass);
			 String query="Select Event from events where Date=? ; ";
			 st=con.prepareStatement(query);
			 st.setString(1, date);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			 eve=new String[i];
			 i=0;
			 st=con.prepareStatement(query);
			 st.setString(1, date);
			 rs=st.executeQuery();
			 while(rs.next()) {
				 
				 eve[i++]=rs.getString(1);
			 }
			 st.close();
			 con.close();
			 return eve;
		 }
		 catch(Exception e){
			e.printStackTrace();
			eve=new String[0];
			return eve;
		 }
		 finally {
		 }
		
	}
	public String deleteEvents(String date,String[] events) {
		 int count=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,user,pass);
			 String query="Delete from events where Date=? and Event=? ; ";
			 
			 for(int i=0;i<events.length;i++) {
				 st=con.prepareStatement(query);
				 st.setString(1, date);
				 st.setString(2, events[i]);
				 int j=st.executeUpdate();
				 count+=j;
			 }
			 st.close();
			 con.close();
			 
		 }
		 catch(Exception e){
			e.printStackTrace();
		 }
		 finally {
			 if(count==events.length) return "Events Deleted Successfully!";
			 else return "Some Events are not deleted!";
		 }
		
	}
}