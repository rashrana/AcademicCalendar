package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ColorTableCellRenderer implements TableCellRenderer {
	private static final TableCellRenderer render=new DefaultTableCellRenderer();
	private JLabel lbl=new JLabel();
	int d;
	
	private nonCalendar c=new nonCalendar();
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c=render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Object result=table.getValueAt(row, column);
		String digit=result.toString();
		if(digit.length()>2) {
			digit=digit.replace("99", "");
			lbl.setBackground(Color.RED);
		}
		else lbl.setBackground(Color.WHITE);
		/*lbl.setText("");
		if(digit.equals("")) {
			lbl.setIcon(new ImageIcon());
		}
		Color color=null;
		ImageIcon img=null;
		switch(digit) {
		case "1":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a1.jpg"));
			//color=new Color(225,225,225);
			break;
		case "2":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a2.jpg"));
			//color=new Color(225,225,200);
			break;
		case "3":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a3.jpg"));
			//color=new Color(225,225,175);
			break;
		case "4":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a4.jpg"));
			//color=new Color(225,225,150);
			break;
		case "5":
			
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a5.jpg"));
			//color=new Color(225,225,125);
			break;
		case "6":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a6.jpg"));
			//color=new Color(225,225,100);
			break;
		case "7":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a7.jpg"));
			//color=new Color(225,225,75);
			break;
		case "8":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a8.jpg"));
			//color=new Color(225,225,50);
			break;
		case "9":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a9.jpg"));
			//color=new Color(225,225,25);
			break;
		case "10":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a10.jpg"));
			//color=new Color(225,225,0);
			break;
		case "11":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a11.jpg"));
			//color=new Color(225,200,225);
			break;
		case "12":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a12.jpg"));
			//color=new Color(225,175,225);
			break;
		case "13":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a13.jpg"));
			//color=new Color(225,150,225);
			break;
		case "14":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a14.jpg"));
			//color=new Color(225,125,225);
			break;
		case "15":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a15.jpg"));
			//color=new Color(225,100,225);
			break;
		case "16":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a16.jpg"));
			//color=new Color(225,75,225);
			break;
		case "17":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a17.jpg"));
			//color=new Color(225,50,225);
			break;
		case "18":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a18.jpg"));
			//color=new Color(225,25,225);
			break;
		case "19":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a19.jpg"));
			//color=new Color(225,0,225);
			break;
		case "20":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a20.jpg"));
			//color=new Color(200,225,225);
			break;
		case "21":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a21.jpg"));
			//color=new Color(175,225,225);
			break;
		case "22":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a22.jpg"));
			//color=new Color(150,225,225);
			break;
		case "23":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a23.jpg"));
			//color=new Color(125,225,225);
			break;
		case "24":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a24.jpg"));
			//color=new Color(100,225,225);
			break;
		case "25":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a25.jpg"));
			//color=new Color(75,225,225);
			break;
		case "26":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a26.jpg"));
			//color=new Color(50,225,225);
			break;
		case "27":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a27.jpg"));
			//color=new Color(25,225,225);
			break;
		case "28":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a28.jpg"));
			//color=new Color(0,225,225);
			break;
		case "29":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a29.jpg"));
			//color=new Color(225,200,200);
			break;
		case "30":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a30.jpg"));
			//color=new Color(200,200,225);
			break;
		case "31":
			//lbl.setText((String)value);
			lbl.setIcon(new ImageIcon("C:/Users/Prashant/Desktop/6th sem/CalenderPictures/a31.jpg"));
			//color=new Color(200,225,200);
			break;
		default:
			break;
		}
		
		lbl.setOpaque(true);
		lbl.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(100,Color.white, Color.PINK), BorderFactory.createLineBorder(new Color(253, 201,185),2)));
		lbl.setFont(new Font("Times New Roman",Font.ITALIC,10));
		lbl.setForeground(Color.BLUE);
		lbl.setText("");
		return lbl;*/
		lbl.setText("   "+digit);
		lbl.setOpaque(true);
		lbl.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(100,Color.white, Color.PINK), BorderFactory.createLineBorder(new Color(253, 201,185),2)));
		lbl.setFont(new Font("Castellar",Font.BOLD,30));
		lbl.setForeground(Color.blue);
		lbl.setAlignmentX(lbl.CENTER_ALIGNMENT);
		return lbl;
	}
	

}
