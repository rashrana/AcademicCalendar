package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Academic extends JPanel {
	private EventsListener listener;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	private JComboBox time;
	private JComboBox type;
	private JLabel eventLabel;
	private TextArea eventField;
	private GridBagConstraints gc;
	private JButton add;
	private String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
	public Academic() {
		setBounds(0,150,175,700);
		setPreferredSize(new Dimension(400,600));
		time=new JComboBox();
		type=new JComboBox();
		day=new JComboBox();
		month=new JComboBox();
		year= new JComboBox();
		add= new JButton("Add");
		
		day.setPreferredSize(new Dimension(50,30));
		month.setPreferredSize(new Dimension(80,30));
		year.setPreferredSize(new Dimension(60,30));
		time.setPreferredSize(new Dimension(100,30));
		
		eventField=new TextArea(5,30);
		eventField.setFont(new Font("Castellar",Font.PLAIN,22));
		
		setLayout(new GridBagLayout());
		
		//ADDING ITEMS INTO DATE
		for(int i=1;i<32;i++) {
			day.addItem(i);
		}
		for(int j=0;j<12;j++) {
			month.addItem(months[j]);
		}
		for(int i=1920;i<2120;i++){
			year.addItem(i);
		}
		
		//ADDING ITEMS INTO TIME
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
			time.addItem(h+":"+minute);
		}
		gc=new GridBagConstraints();
		
		setBorder(BorderFactory.createTitledBorder("Add Events"));
		
		//ADDING ITEMS INTO TYPE
		type.addItem("SPORTS");
		type.addItem("FESTIVAL");
		type.addItem("ASSIGNMENTS");
		type.addItem("MEETINGS");
		type.addItem("OTHERS");
		
		
		//FIRST PANEL
		JPanel date=new JPanel();
		date.add(new JLabel("Day: "));
		date.add(day);
		date.add(new JLabel("Month:"));
		date.add(month);
		date.add(new JLabel("Year: "));
		date.add(year);
		
		
		
		month.setSelectedItem("April");
		year.setSelectedItem(2020);
		
		gc.weightx=0.1;
		gc.weighty=1;
		
		gc.gridx=0;
		gc.gridy=0;
		date.setLayout(new FlowLayout());
		add(date,gc);
		
		
		
		//SECOND PANEL
		
		JPanel t=new JPanel();
		t.setLayout(new FlowLayout());
		t.add(new JLabel("Time: "));
		t.add(time);
		
	    gc.gridx=0;
	    gc.gridy++;
	    gc.weighty=0.05;
	    gc.ipadx=50; 
	    add(t,gc);
	    
	    //THIRD PANEL
	    
	    JPanel e=new JPanel();
		e.setLayout(new FlowLayout());
		e.add(new JLabel("Type: "));
		e.add(type);
		
		
	    gc.gridx=0;
	    gc.gridy++;;
	    gc.weighty=0.05;
	    gc.ipadx=50; 
	    add(e,gc);
	    
	    //FOURTH LEVEL  
	    
		gc.gridy++;
		gc.gridx=0;
		gc.anchor=gc.LAST_LINE_START;
		gc.weighty=1.5;
		add(new JLabel("Event: "),gc);
		
		//THIRD
		gc.weighty=0.5;
		gc.gridy++;
		gc.gridx=0;
		gc.ipady=1;
		gc.anchor=gc.LINE_START;
		add(eventField,gc);
		
		//FOURTH
		gc.gridy++;
		gc.gridx=0;
		gc.ipadx=50;
		gc.weighty=1;
		gc.anchor=gc.NORTH;
		add(add,gc);
		
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int d= (Integer)day.getSelectedItem();
				int m= (Integer)month.getSelectedIndex()+1;
				int y= (Integer)year.getSelectedItem();
				String selDate = y+"-"+m+"-"+d;
				String seltime = (String)time.getSelectedItem();
				String seltype =(String)type.getSelectedItem();
				String selevent = eventField.getText();
				if(!selevent.equals("")) {
					EventsAddEvent eve = new EventsAddEvent(this,selevent,selDate,seltime,seltype);
					if(listener != null) {
						listener.eventAdded(eve);
						eventField.setText("");
					}
				} 
				else {
					JOptionPane.showMessageDialog(Academic.this, "Event Field is Empty!", "Message",  JOptionPane.YES_OPTION);
				}
				
			}
			
		});
	}
	public void setEventsListener(EventsListener listener) {
		this.listener=listener;
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f=new JFrame();
				JPanel a=new Academic();
				f.add(a);
				f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
				f.setBounds(0, 0, 500, 600);
				f.setVisible(true);
			}
			
		});
	}
}
