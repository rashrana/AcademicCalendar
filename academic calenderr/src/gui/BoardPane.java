package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import storage.eventAdder;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class BoardPane extends JPanel {

	private JPanel eventboard;
	private JTextArea other;
	private Font f;
	private ResultSet r;
	private eventAdder add;
	private JTextArea sports;
	private JTextArea festival;
	private JTextArea assignment;
	private JTextArea meeting;
	private String[] eve;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardPane frame = new BoardPane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BoardPane() {
		
		ImageIcon img=new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\wetglass");
		Image im=img.getImage();
		Image temp=im.getScaledInstance(500,600, Image.SCALE_SMOOTH);
		img=new ImageIcon(temp);
		
		setVisible(true);
		setBounds(176,150,1106,666);
		//eventboard = new JPanel();
		setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		//setContentPane(eventboard);
		setLayout(null);
		f=new Font("Calibri", Font.PLAIN, 25);
		add= new eventAdder();
		
		JScrollPane sportscroll = new JScrollPane();
		sportscroll.setBounds(10, 10, 1086, 117);
		add(sportscroll);
		
		sports = new JTextArea();
		sports.setEditable(false);
		sports.setForeground(new Color(240, 128, 128));
		sports.setText("sports");
		sports.setFont(f);
		sportscroll.setViewportView(sports);
		sports.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null), "SPORTS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		
		JScrollPane festivalscroll = new JScrollPane();
		festivalscroll.setBounds(10, 137, 1086, 117);
		add(festivalscroll);
		
		festival = new JTextArea();
		festival.setEditable(false);
		festival.setText("festival");
		festival.setForeground(new Color(0, 128, 0));
		festival.setFont(f);
		festivalscroll.setViewportView(festival);
		festival.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null), "FESTIVALS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		
		JScrollPane assignmentscroll = new JScrollPane();
		assignmentscroll.setBounds(10, 264, 1086, 117);
		add(assignmentscroll);
		
		assignment = new JTextArea();
		assignment.setEditable(false);
		assignment.setForeground(new Color(148, 0, 211));
		assignment.setText("assignment");
		assignment.setFont(f);
		assignmentscroll.setViewportView(assignment);
		assignment.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null), "ASSIGNMENTS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		
		JScrollPane meetingscroll = new JScrollPane();
		meetingscroll.setBounds(10, 391, 1086, 117);
		add(meetingscroll);
		
		meeting = new JTextArea();
		meeting.setEditable(false);
		meeting.setForeground(new Color(60, 179, 113));
		meeting.setText("meeting");
		meeting.setFont(f);
		meetingscroll.setViewportView(meeting);
		meeting.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null), "MEETINGS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		
		JScrollPane otherscroll = new JScrollPane();
		otherscroll.setBounds(10, 518, 1086, 117);
		add(otherscroll);
		
		other = new JTextArea();
		other.setEditable(false);
		other.setForeground(new Color(255, 165, 0));
		other.setText("other");
		other.setFont(f);
		otherscroll.setViewportView(other);
		other.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null), "OTHERS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		other.setColumns(10);
		
		
	}
	public void showEvents(String fdate,String ldate) {
		eve=add.getEvent(fdate, ldate);
		sports.setText("Date\t\tTime\t\tEvent\n");
		festival.setText("Date\t\tTime\t\tEvent\n");
		assignment.setText("Date\t\tTime\t\tEvent\n");
		meeting.setText("Date\t\tTime\t\tEvent\n");
		other.setText("Date\t\tTime\t\tEvent\n");
		
		for(int j=0;j<eve.length;j++) {
			if(eve[j].contains("SPORTS")) {
				eve[j]=eve[j].replace("SPORTS", "\n");
				sports.append(eve[j]);
			}
			if(eve[j].contains("FESTIVAL")) {
				eve[j]=eve[j].replace("FESTIVAL", "\n");
				festival.append(eve[j]);
			}
			if(eve[j].contains("ASSIGNMENTS")) {
				eve[j]=eve[j].replace("ASSIGNMENTS", "\n");
				assignment.append(eve[j]);
			}
			if(eve[j].contains("MEETINGS")) {
				eve[j]=eve[j].replace("MEETINGS", "\n");
				meeting.append(eve[j]);
			}
			if(eve[j].contains("OTHERS")) {
				eve[j]=eve[j].replace("OTHERS", "\n");
				other.append(eve[j]);
			}
	
		}
	}
}
