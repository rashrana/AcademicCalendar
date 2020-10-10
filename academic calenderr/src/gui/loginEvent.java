package gui;

import java.util.EventObject;

public class loginEvent extends EventObject {
	private String username;
	private String password;
	public loginEvent(Object source,String username,String password) {
		super(source);
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}