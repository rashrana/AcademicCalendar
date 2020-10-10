package connector;

import java.sql.ResultSet;

import gui.EventsAddEvent;
import gui.loginEvent;
import storage.account;
import storage.eventAdder;

public class connector {
	private account acc=new account();
	private eventAdder eve=new eventAdder();
	public String addAccount(loginEvent e) {
		String username=e.getUsername();
		String password=e.getPassword();
		return acc.addAccount(username,password);
	}
	public boolean checkAccount(loginEvent e) {
		String username=e.getUsername();
		String password=e.getPassword();
		return acc.checkAccount(username,password);
	}
	public String addEvent(EventsAddEvent e) {
		return eve.addEvent(e.getEvent(), e.getType(),e.getDate(), e.getTime());
	}
	/*public ResultSet getEvent(EventsAddEvent e) {
		return eve.getEvent();
	}*/
}
