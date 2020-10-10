package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import connector.connector;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

public class calender extends JFrame {
	private nonCalendar non;
	private JScrollPane eventScroll;
	private JPanel dateShow;
	private JButton next;
	private JButton previous;
	private JLabel MandY;
	private JPanel dateChooser;
	private JComboBox month;
	private JComboBox year;
	private JButton turn;
	private JButton reset;
	private BoardPane board;
	private calendarPanel cal;
	private connector connect;
	private Academic academic;
	private JPanel title;
	private JLabel titleLabel;
	private loginForm login;
	private JMenuBar menuBar;
	private JMenu filemenu;
	private JCheckBoxMenuItem showEvents;
	private JMenuItem logout;
	private String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	public calender() {
	
		super("Academic Calender of Events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(screenSize.getSize());
		//setSize(getMaximumSize());
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		//setBounds(0,0,1600,950);
		
		ImageIcon img=new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\wetglass");
		Image im=img.getImage();
		Image temp=im.getScaledInstance(1200, 1000, Image.SCALE_SMOOTH);
		img=new ImageIcon(temp);
		//getContentPane().setIcon(img);
		
		non=new nonCalendar();
		dateShow=new JPanel();
		dateChooser=new JPanel();
		board=new BoardPane();
		cal=new calendarPanel(calender.this);
		connect=new connector();
		login=new loginForm();
		title=new JPanel();
		academic=new Academic();
		
		login.setVisible(true);
		academic.setVisible(false);
		cal.setVisible(false);
		board.setVisible(false);
		dateChooser.setVisible(false);
		
		title.setLayout(new BorderLayout());
		titleLabel=new JLabel("LOGIN");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Times New Roman",Font.BOLD,40));
		titleLabel.setPreferredSize(new Dimension(400,70));
		titleLabel.setBorder(BorderFactory.createEtchedBorder());
	
		title.add(titleLabel,BorderLayout.CENTER);
		
		login.setOpaque(true);
		
		getContentPane().add(cal,BorderLayout.CENTER);
		getContentPane().add(title,BorderLayout.NORTH);
		getContentPane().add(academic,BorderLayout.WEST);
		getContentPane().add(login,BorderLayout.CENTER);
		getContentPane().add(dateChooser,BorderLayout.SOUTH);
		
		//IMPLEMENTING DATECHOOSER
		dateChooser.setPreferredSize(new Dimension(800,100));
		dateChooser.setLayout(new FlowLayout());
		month=new JComboBox();
		year=new JComboBox();
		turn=new JButton("Turn");
		turn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y=year.getSelectedIndex();
				int m=month.getSelectedIndex();
				y+=1950;
				cal.refresh(y,m+1);
				MandY.setText(months[m]+"/"+y);
				if(m!=11 || y!=2049) next.setEnabled(true);
				if(m!=0 || y!=1950) previous.setEnabled(true);
				if(m==11 & y==2049) next.setEnabled(false);
				if(m==0 & y==1950) previous.setEnabled(false);
				
				m++;
				String fdate=y+"-"+m+"-01";
				if(m==12) {
					y++;
					m=0;
				}
				m++;
				String ldate=y+"-"+m+"-01";
				board.setVisible(board.isVisible());
				board.showEvents(fdate, ldate);
			}
			
		});
		reset=new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y=non.getCuryear();
				int m=non.getCurmonth()-1;
				int x=m+1;
				MandY.setText(months[x]+"/"+y);
				month.setSelectedIndex(m);
				year.setSelectedItem(y);
				
				cal.refresh(y,m+1);
				if(m!=11 || y!=2049) next.setEnabled(true);
				if(m!=0 || y!=1950) previous.setEnabled(true);
				if(m==11 & y==2049) next.setEnabled(false);
				if(m==0 & y==1950) previous.setEnabled(false);
				
				m++;
				String fdate=y+"-"+m+"-01";
				if(m==12) {
					y++;
					m=0;
				}
				m++;
				String ldate=y+"-"+m+"-01";
				board.setVisible(board.isVisible());
				board.showEvents(fdate, ldate);
			}
			
		});
		reset.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MandY.setText(months[non.getCurmonth()-1]+"/"+non.getCuryear());
			}
		});
				
		for(int i=0;i<12;i++) {
			month.addItem(months[i]);
		}
		for(int i=1950;i<2050;i++) {
			year.addItem(i);
		}
		month.setSelectedIndex(non.getCurmonth()-1);
		year.setSelectedItem(non.getCuryear());
		dateChooser.add(new JLabel("Months: "));
		dateChooser.add(month);
		dateChooser.add(new JLabel("Year: "));
		dateChooser.add(year);
		dateChooser.add(turn);
		dateChooser.add(reset);
		
		//IMPLEMENTING DATESHOW
		next=new JButton("Next");
		previous=new JButton("Previous");
		MandY=new JLabel(months[non.getCurmonth()-1]+"/"+non.getCuryear());
		MandY.setFont(new Font("Castellar",Font.BOLD,20));
		dateShow.setLayout(new GridBagLayout());
		dateShow.setBorder(BorderFactory.createEtchedBorder());
		GridBagConstraints g=new GridBagConstraints();
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y=year.getSelectedIndex();
				int m=month.getSelectedIndex();
				y+=1950;
				if(m==10 & y==2049) {
					next.setEnabled(false);
					m++;
				}
				else if(m==11 & y!=2049) {
					m=0;
					y++;
				}
				else {
					m++;
				}
				if(m!=0 & y==1950) previous.setEnabled(true);
				cal.refresh(y,m+1);
				MandY.setText(months[m]+"/"+y);
				year.setSelectedIndex(y-1950);
				month.setSelectedIndex(m);
				
				m++;
				String fdate=y+"-"+m+"-01";
				if(m==12) {
					y++;
					m=0;
				}
				m++;
				String ldate=y+"-"+m+"-01";
				board.setVisible(board.isVisible());
				board.showEvents(fdate, ldate);
			}
			
		});
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y=year.getSelectedIndex();
				int m=month.getSelectedIndex();
				y+=1950;
				if(m==1 & y==1950) {
					previous.setEnabled(false);
					m--;
				}
				else if(m==0 & y!=1950) {
					m=11;
					y--;
				}
				else {
					m--;
				}
				if(m!=11 & y==2049) next.setEnabled(true);
				cal.refresh(y,m+1);
				MandY.setText(months[m]+"/"+y);
				year.setSelectedIndex(y-1950);
				month.setSelectedIndex(m);
				
				m++;
				String fdate=y+"-"+m+"-01";
				if(m==12) {
					y++;
					m=0;
				}
				m++;
				String ldate=y+"-"+m+"-01";
				board.setVisible(board.isVisible());
				board.showEvents(fdate, ldate);
			}
			
		});
		
		g.gridx=0;
		g.gridy=0;
		g.weightx=13;
		g.anchor=g.LINE_START;
		dateShow.add(previous,g);
		
		GridBagConstraints gc=new GridBagConstraints();
		gc.gridx=1;
		gc.gridy=0;
		gc.weightx=1;
		gc.anchor=gc.CENTER;
		dateShow.add(MandY,gc);
		
		GridBagConstraints gcc=new GridBagConstraints();
		gcc.gridy=0;
		gcc.gridx=2;
		gcc.weightx=13;
		gcc.ipadx=30;
		gcc.anchor=gcc.LINE_END;
		dateShow.add(next,gcc);
		dateShow.setVisible(false);
		
		login.setLoginListener(new LoginListener() {
			public void loginEventOccured(loginEvent e) {
				boolean check=connect.checkAccount(e);
				login.setVisible(!check);
				if (check) {
					 login.getuserField().setText("");
					 login.getpassField().setText("");
					
 					 titleLabel.setText("Academic Calender");
 					 titleLabel.setPreferredSize(new Dimension(175,70));
 					 titleLabel.setFont(new Font("Times New Roman",Font.BOLD,25));
					 academic.setVisible(true);
					 cal.setVisible(true);
					 getContentPane().add(cal,BorderLayout.CENTER);
					 dateChooser.setVisible(true);
					 menuBar.add(filemenu);

					 title.add(dateShow,BorderLayout.EAST);
					 dateShow.setPreferredSize(new Dimension(1125,70));
					 dateShow.setVisible(true);
				
				}
				 else JOptionPane.showMessageDialog(calender.this, "Wrong Username or Password!");
			}

			public void signUpEventOccured(loginEvent e) {
				String msg=connect.addAccount(e);
				JOptionPane.showMessageDialog(calender.this, msg);
			}
		});
		
		academic.setEventsListener(new EventsListener() {
			public void eventAdded(EventsAddEvent e) {
				String msg=connect.addEvent(e);
				boardChange();
				JOptionPane.showMessageDialog(calender.this, msg);
			}
			
		});
		
		
		//IMPLEMENTIG MENU
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		filemenu = new JMenu("File");
		logout=new JMenuItem("Logout");
		
		
		filemenu.add(logout);
		showEvents = new JCheckBoxMenuItem("Show Events");
		filemenu.add(showEvents);
		showEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean c= showEvents.isSelected();
				if(c) {
					boardChange();
					board.setVisible(true);
					getContentPane().add(board,BorderLayout.CENTER);
					cal.setVisible(false);
					dateChooser.setVisible(false);
				}
				else {
					cal.setVisible(true);
					getContentPane().add(cal,BorderLayout.CENTER);
					board.setVisible(false);
					dateChooser.setVisible(true);
				}
			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				academic.setVisible(false);
				cal.setVisible(false);
				dateChooser.setVisible(false);
				titleLabel.setText("LOGIN");
				titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
				titleLabel.setFont(new Font("Times New Roman",Font.BOLD,40));
				titleLabel.setPreferredSize(new Dimension(400,70));
				dateShow.setVisible(false);
				board.setVisible(false);
			}
			
		});
		
		filemenu.setMnemonic(KeyEvent.VK_F);
		logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		showEvents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
	}
	public void boardChange() {
		int y=year.getSelectedIndex()+1950;
		int m=month.getSelectedIndex()+1;
		String fdate=y+"-"+m+"-01";
		if(m==12) {
			y++;
			m=0;
		}
		m++;
		String ldate=y+"-"+m+"-01";
		
		board.showEvents(fdate, ldate);
	}
	public JComboBox getMonth() {
		return month;
	}
	public JComboBox getYear() {
		return year;
	}
}
