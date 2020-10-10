package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;

import storage.eventAdder;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class ShowAdd extends JFrame {

	private JPanel contentPane;
	private JPanel lol;
	private JScrollPane show;
	private JScrollPane panel;
	private JScrollPane Deletion;
	private eventAdder data;
	private JCheckBox[] listto;
	private String[] even;
	private JButton delbtn;
	private JPanel list;
	private JTextArea eventshow;
	private JLabel e;
	private JButton OK;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAdd frame = new ShowAdd("2020-04-01",1);
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
	public ShowAdd(String d,int o) {
		setBounds(100, 100, 766, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		data=new eventAdder();
		
		even=data.getEventOnly(d);
		
		
		Deletion = new JScrollPane();
		Deletion.setBounds(0, 0, 766, 605);
		
		
		JLabel head = new JLabel("Select the Events you want to Delete!");
		head.setForeground(new Color(25, 25, 112));
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
		Deletion.setColumnHeaderView(head);
		
		list = new JPanel();
		Deletion.setViewportView(list);
		list.setLayout(null);
		
		delbtn = new JButton("Delete");
		delbtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		delbtn.setForeground(new Color(25, 25, 112));
		delbtn.setFont(new Font("Calibri", Font.PLAIN, 20));
		//delbtn.setBounds(272, 408, 206, 44);
		//list.add(delbtn);
		
		if(even.length!=0) {
			listto=new JCheckBox[even.length];
			int i;
			for(i=0;i<even.length;i++) {
				listto[i]=new JCheckBox(even[i]);
				listto[i].setFont(new Font("Calibri", Font.PLAIN, 20));
				listto[i].setBounds(50,70+(50*i),550,44);
				list.add(listto[i]);
			}
			delbtn.setBounds(50,70+(50*i),206,44);
			list.add(delbtn);
		}
		
		delbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int count=0,i;
				for( i=0;i<even.length;i++) {
					if(listto[i].isSelected()) count++;
				}
				if(count!=0) {
					String send[]=new String[count];
					count=0;
					for( i=0;i<even.length;i++) {
						if(listto[i].isSelected()) send[count++]=new String(listto[i].getText());
					}
					String msg=data.deleteEvents(d,send);
					JOptionPane.showMessageDialog(ShowAdd.this, msg);
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(ShowAdd.this, "No items Selected!");
					setVisible(false);
				}
			}
			
		});
		
		
		
		
		
		
		//show event
		show = new JScrollPane();
		show.setBounds(0, 0, 766, 605);
		show.setLayout(null);
		
		String[] events=data.getSpecificEvent(d);
		
		eventshow = new JTextArea();
		eventshow.setText("Time\tType\t\tEvent\n");
		eventshow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null));
		eventshow.setForeground(new Color(25, 25, 112));
		eventshow.setFont(new Font("Calibri", Font.PLAIN, 20));
		eventshow.setEditable(false);
		eventshow.setBounds(10, 123, 722, 340);
		show.add(eventshow);
		for(int j=0;j<events.length;j++) {
			eventshow.append(events[j]+"\n");
		}
		
		e = new JLabel("Events");
		e.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		e.setHorizontalAlignment(SwingConstants.CENTER);
		e.setForeground(new Color(25, 25, 112));
		e.setFont(new Font("Calibri", Font.PLAIN, 35));
		e.setBounds(10, 10, 722, 67);
		show.add(e);
		
		OK = new JButton("OK");
		OK.setForeground(new Color(25, 25, 112));
		OK.setFont(new Font("Calibri", Font.PLAIN, 20));
		OK.setBounds(260, 484, 234, 36);
		show.add(OK);
		OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
		
		
		
		//Add event
		panel = new JScrollPane();
		panel.setBounds(0, 0, 700, 550);
		panel.setLayout(null);
		
		JLabel Header = new JLabel("ADD EVENT");
		Header.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		Header.setForeground(new Color(25, 25, 112));
		Header.setFont(new Font("Calibri", Font.BOLD, 35));
		Header.setHorizontalAlignment(SwingConstants.CENTER);
		Header.setBounds(10, 5, 722, 93);
		panel.add(Header);
		
		JComboBox Type = new JComboBox();
		Type.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		Type.setForeground(new Color(65, 105, 225));
		Type.setFont(new Font("Calibri", Font.PLAIN, 20));
		Type.setBounds(145, 130, 173, 29);
		panel.add(Type);
		
		Type.addItem("SPORTS");
		Type.addItem("FESTIVAL");
		Type.addItem("ASSIGNMENTS");
		Type.addItem("MEETINGS");
		Type.addItem("OTHERS");
		
		JComboBox Time = new JComboBox();
		Time.setForeground(new Color(65, 105, 225));
		Time.setFont(new Font("Calibri", Font.PLAIN, 20));
		Time.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		Time.setBounds(421, 129, 105, 29);
		panel.add(Time);
		
		for(int i=0;i<48;i++) {
			int hour=i/2;
			String minute;
			String h;
			if (i%2==0) minute="00";
			else minute="30";
			if(hour/10==0) {
				h= "0"+hour;
			}
			else {
				h=""+hour;
			}
			Time.addItem(h+":"+minute);
		}
		
		JButton adder = new JButton("ADD");
		adder.setForeground(new Color(25, 25, 112));
		adder.setFont(new Font("Calibri", Font.PLAIN, 20));
		adder.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(25, 25, 112), null));
		adder.setBounds(269, 482, 173, 37);
		panel.add(adder);
		
		
		JLabel lblNewLabel = new JLabel("Type:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(47, 130, 88, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(352, 130, 59, 29);
		panel.add(lblNewLabel_1);
		
		JLabel Event = new JLabel("Event:");
		Event.setForeground(new Color(25, 25, 112));
		Event.setFont(new Font("Calibri", Font.PLAIN, 20));
		Event.setBounds(82, 281, 111, 29);
		panel.add(Event);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 318, 527, 129);
		panel.add(scrollPane);
		
		JTextArea eventField = new JTextArea();
		scrollPane.setViewportView(eventField);
		eventField.setForeground(new Color(65, 105, 225));
		eventField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(25, 25, 112), null));
		eventField.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		adder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tim=(String)Time.getSelectedItem();
				String typ=(String)Type.getSelectedItem();
				String ev=eventField.getText();
				String msg=data.addEvent(ev,typ,d,tim);
				JOptionPane.showMessageDialog(ShowAdd.this, msg);
				setVisible(false);
			}
			
		});
		
		operation(o);
		
		
		
	}
	public void operation(int o) {
		if(o==0) {
			
			show.setVisible(true);
			panel.setVisible(false);
			Deletion.setVisible(false);
			contentPane.add(show);
			setVisible(true);
		}
		else if(o==1) {
			
			show.setVisible(false);
			panel.setVisible(true);
			Deletion.setVisible(false);
			contentPane.add(panel);
			setVisible(true);
		}
		else if(o==2) {
			show.setVisible(false);
			panel.setVisible(false);
			contentPane.add(Deletion);
			if(even.length==0) {
				JOptionPane.showMessageDialog(ShowAdd.this, "There's no any event available for this date.");
				setVisible(false);
			}
			else {
				Deletion.setVisible(true);
				setVisible(true);
			}
			
		}
	}
}
