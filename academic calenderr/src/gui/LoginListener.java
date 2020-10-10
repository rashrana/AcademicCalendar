package gui;

import java.util.EventListener;

public interface LoginListener extends EventListener {
	public void loginEventOccured(loginEvent e);
	public void signUpEventOccured(loginEvent e);
}
