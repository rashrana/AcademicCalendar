package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class account {
 private String username;
 private String password;
 private String url="jdbc:mysql://localhost:3325/calender";
 private String user="root";
 private String pass="";
 
 public String addAccount (String u,String p)  {
	 username=u;
	 password=p;
	 try {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
		 }
		 catch(ClassNotFoundException e) { 
			 e.getMessage();
		 }
		 Connection con=DriverManager.getConnection(url,user,pass);
		 PreparedStatement st=con.prepareStatement("insert into account values(?,?)");
		 st.setString(1,username);
		 st.setString(2,password);
		 st.executeUpdate();
		 st.close();
		 con.close();
		 return "Account Successfully Created!";
		  }
  catch(Exception e){
		return e.getMessage(); 
	 }	
 }
 public boolean checkAccount(String u,String p) {
	 username=u;
	 password=p;
	 boolean check=false; 
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection(url,user,pass);
		 String query="Select * from account";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 while(rs.next()) {
			 if(rs.getString(1).equals(username) & rs.getString(2).equals(password)) {
			  check=true;
			  break;
			 }
		 }
		 st.close();
		 con.close();
	 }
	 catch(Exception e){
		e.printStackTrace(); 
	 }
	 finally {
		 return check;
	 }
 }
}
