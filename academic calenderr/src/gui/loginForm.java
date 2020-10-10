package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginForm extends JPanel{
	private Font f=new Font("Times New Roman",Font.BOLD,22);
	private LoginListener loginlistener;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField userField;
	private JPasswordField passField;
	private JButton loginBtn;
	
	private JCheckBox signUpCheck;
	private JLabel newuserLabel;
	private JLabel newpasswordLabel;
	private JTextField newuserField;
	private JPasswordField newpassField;
	private JButton signUpBtn;
	
	public JTextField getuserField() {
		return userField;
	}
	public JTextField getpassField() {
		return passField;
	}
 public loginForm(){
	 userLabel= new JLabel("Username: ");
	 passwordLabel=new JLabel("Password: ");
	 userField=new JTextField(10);
	 passField=new JPasswordField(10);
	 loginBtn=new JButton("Login");
	 
	 
	 
	 signUpCheck=new JCheckBox("Create new account?");
	 newuserLabel= new JLabel("New Username: ");
	 newpasswordLabel=new JLabel("New Password: ");
	 newuserField=new JTextField(10);
	 newpassField=new JPasswordField(10);
	 signUpBtn=new JButton("Sign Up");
	 
	 newuserLabel.setEnabled(false);
	 newpasswordLabel.setEnabled(false);
	 newuserField.setEnabled(false);
	 newpassField.setEnabled(false);
	 signUpBtn.setEnabled(false);
	 
	 userLabel.setFont(f);
	 userField.setFont(f);
	 passwordLabel.setFont(f);
	 passField.setFont(f);
	 signUpCheck.setFont(f);
	 newuserLabel.setFont(f);
	 newuserField.setFont(f);
	 newpasswordLabel.setFont(f);
	 newpassField.setFont(f);
	 loginBtn.setFont(f);
	 signUpBtn.setFont(f);
	 
	 Dimension dim=getPreferredSize();
	 dim.width=200;
	 setPreferredSize(dim);
	 setBorder(BorderFactory.createEtchedBorder());
	 
	 createLayout();
	 
	
 }
 public void createLayout() {
	 setLayout(new GridBagLayout());
	 GridBagConstraints gc= new GridBagConstraints();
	 
	
	 gc.weightx=1;
	 gc.weighty=0.5;
	 
	 gc.gridx=0;
	 gc.gridy=0;

	 
	 
	 //FIRST ROW
	 gc.gridheight=1;
	 gc.gridx=0;
	 gc.gridy=1;
	 gc.anchor=GridBagConstraints.LAST_LINE_END;
	 gc.fill=GridBagConstraints.NONE;
	 gc.insets=new Insets(0,0,0,5);
	 add(userLabel,gc);
	 
	 gc.gridx=1;
	 gc.anchor=GridBagConstraints.LAST_LINE_START;
	 add(userField,gc);
	 
	 //SECOND ROW
	 gc.gridy++;
	 gc.weighty=0.1;
	 
	 gc.gridx=0;
	 gc.anchor=GridBagConstraints.LINE_END;
	 gc.insets=new Insets(0,0,0,5);
	 add(passwordLabel,gc);
	 
	 gc.gridx=1;
	 gc.anchor=GridBagConstraints.LINE_START;	 
	 add(passField,gc);
	 
	 //THIRD ROW
	 gc.gridy++;
	 
	 gc.gridx=1;
	 gc.ipadx=60;
	 gc.anchor=GridBagConstraints.LINE_START;
	 add(loginBtn,gc);
	 
	 loginBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loginEvent ev= new loginEvent(this,userField.getText(),passField.getText());
			if(loginlistener != null)
				loginlistener.loginEventOccured(ev);
		}
		 
	 });
	 
	//FOURTH ROW
	gc.gridy++;
	gc.ipadx=0;
			 
	gc.gridx=1;
	gc.fill=GridBagConstraints.NONE;
	gc.anchor=GridBagConstraints.LINE_START;
	add(signUpCheck,gc);
	
	signUpCheck.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			boolean tick=signUpCheck.isSelected();
			if(tick) {
				 userLabel.setEnabled(false);
				 passwordLabel.setEnabled(false);
				 userField.setEnabled(false);
				 passField.setEnabled(false);
				 loginBtn.setEnabled(false);
				 
				 newuserLabel.setEnabled(true);
				 newpasswordLabel.setEnabled(true);
				 newuserField.setEnabled(true);
				 newpassField.setEnabled(true);
				 signUpBtn.setEnabled(true);
			}
			if(!tick) {
				 userLabel.setEnabled(true);
				 passwordLabel.setEnabled(true);
				 userField.setEnabled(true);
				 passField.setEnabled(true);
				 loginBtn.setEnabled(true);
				 
				 newuserLabel.setEnabled(false);
				 newpasswordLabel.setEnabled(false);
				 newuserField.setEnabled(false);
				 newpassField.setEnabled(false);
				 signUpBtn.setEnabled(false);
			}
			userField.setText("");
			passField.setText("");
			newuserField.setText("");
			newpassField.setText("");
		}
		
	});
	
	 //FIFTH ROW
	 gc.gridx=0;
	 gc.gridy++;
	 gc.anchor=GridBagConstraints.LAST_LINE_END;
	 gc.insets=new Insets(0,0,0,5);
	 add(newuserLabel,gc);
	 
	 gc.gridx=1;
	 gc.anchor=GridBagConstraints.LAST_LINE_START;
	 add(newuserField,gc);
	 
	 //SIXTH ROW
	 gc.gridy++;
	 gc.weighty=0.1;
	 
	 gc.gridx=0;
	 gc.anchor=GridBagConstraints.LINE_END;
	 gc.insets=new Insets(0,0,0,5);
	 add(newpasswordLabel,gc);
	 
	 gc.gridx=1;
	 gc.anchor=GridBagConstraints.LINE_START;	 
	 add(newpassField,gc);
	 
	 //SEVENTH ROW
	 gc.gridy++;
	 gc.weighty=1;
	 
	 gc.gridx=1;
	 gc.ipadx=60;
	 gc.anchor=GridBagConstraints.FIRST_LINE_START;
	 add(signUpBtn,gc);	
	 
	 signUpBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			loginEvent ev= new loginEvent(this,newuserField.getText(),newpassField.getText());
			if(loginlistener != null)
				loginlistener.signUpEventOccured(ev);
		}
		 
	 });
 }
 public void setLoginListener(LoginListener listener) {
	 this.loginlistener=listener;
 }
}
