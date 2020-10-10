package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class calendarPanel extends JPanel  {
	private JTable table;
	private nonCalendar cal;
	private ColorTableCellRenderer rend;
	public calendarTableModel tablemodel;
	private String row[][]=new String[6][7];;
	private JPopupMenu popup;
	private String dateformat;
	//private String dateformat;
	
	
	
	
	public boolean isEditing() {
		return false;
	}
	public String day[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	
	
	public calendarPanel(calender parent) {
		//setBounds(176,150,1300,700);
		
		
		ImageIcon img=new ImageIcon("C:\\Users\\Prashant\\Desktop\\6th sem\\Ewallet\\wetglass");
		Image im=img.getImage();
		Image temp=im.getScaledInstance(1200, 1000, Image.SCALE_SMOOTH);
		img=new ImageIcon(temp);
		//getContentPane().setIcon(img);
		
		cal=new nonCalendar();
		table=new JTable(row,day);
		
		tablemodel=new calendarTableModel(cal.getChoosenyear(),cal.getChoosenmonth());
		table.setModel(tablemodel);
		
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createLineBorder(Color.white, 10, true)));
		table.setRowHeight(100);
		//table.setRowMargin(10);
		//table.setBounds(20,20,200,200);
		table.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,20));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(225,20,10));
		table.getTableHeader().setForeground(new Color(225,225,225));
		rend= new ColorTableCellRenderer();
		//table.setDefaultRenderer(Object.class, rend);
	
		for(int i=0;i<7;i++) {
			
			table.getColumnModel().getColumn(i).setCellRenderer(rend);
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
	
		/*table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		*/
		table.setEnabled(false);
		table.setShowGrid(false);
		//table.setGridColor(new Color(225,0,0));
		table.setIntercellSpacing(new Dimension(20,20));
		JScrollPane s=new JScrollPane(table);
		s.setPreferredSize(new Dimension(600,500));
		setVisible(true);
		setLayout(new BorderLayout());
		setPreferredSize(getPreferredSize());
		add(s,BorderLayout.CENTER);
		
		
		//implementing popup 
		popup=new JPopupMenu();
		JMenuItem AddEvent=new JMenuItem("Add Event");
		JMenuItem ShowEvent=new JMenuItem("Show Event");
		JMenuItem DeleteEvent=new JMenuItem("Delete Event");
		popup.add(AddEvent);
		popup.add(ShowEvent);
		popup.add(DeleteEvent);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row=table.rowAtPoint(e.getPoint());
				int col=table.columnAtPoint(e.getPoint());
				int day=tablemodel.getSelectedItem(row,col);
				int year=parent.getYear().getSelectedIndex()+1950;
				int month=parent.getMonth().getSelectedIndex()+1;
				
				dateformat = year+"-"+month+"-"+day;
				
				//month++;
				//dateformat = year+"-"+month+"-"+day;
				if(e.getButton()==MouseEvent.BUTTON3) {
					popup.show(table,e.getX(),e.getY());
				}
			}
		});
		AddEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new ShowAdd(dateformat,1);
					}
				});
			}
			
		});
		ShowEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						
						new ShowAdd(dateformat,0);
					}
				});
			}
			
		});
		DeleteEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new ShowAdd(dateformat,2);
					}
				});
			}
			
		});
		
		
		
	}
	public void refresh(int y,int m) {
		tablemodel=new calendarTableModel(y,m);
		table.setModel(tablemodel);
		tablemodel.fireTableDataChanged();
		for(int i=0;i<7;i++) {
			
			table.getColumnModel().getColumn(i).setCellRenderer(rend);
			table.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
	}
	
}
