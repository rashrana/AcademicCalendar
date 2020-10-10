package gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class application extends JFrame {
 public static void main(String args[]) {
	 SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new calender();	
		} 
	 });
 }
}
