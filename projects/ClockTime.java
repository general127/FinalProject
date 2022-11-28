package projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ClockTime extends JFrame implements ActionListener{

	private JPanel contentPane;
	JLabel display;
	DecimalFormat df;
	JPanel watchPanel,controlPanel;
	Timer t;
	JOptionPane dialog;
	 String stringTime;  
     int hour, minute, second;  
     private JLabel display_1 = new JLabel("New Form");
     public static String [] array = {"Europe/Copenhagen","US/Michigan","Asia/Istanbul","Iran","Asia/Singapore","Australia/LHI"};
     public static JComboBox dropdown = new JComboBox(array);
     SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());
     
     public static String timezone =  "Europe/Copenhagen";
     
  
   
     private static Date offsetTimeZone(Date date, String fromTZ, String toTZ)
     {
         // Construct FROM and TO TimeZone instances
         TimeZone fromTimeZone = TimeZone.getTimeZone(fromTZ);
         TimeZone toTimeZone = TimeZone.getTimeZone(toTZ);

         // Get a Calendar instance using the default time zone and locale.
         Calendar calendar = Calendar.getInstance();

         // Set the calendar's time with the given date
         calendar.setTimeZone(fromTimeZone);
         calendar.setTime(date);

         //System.out.println("Input: " + calendar.getTime() + " in " + fromTimeZone.getDisplayName());

         // FROM TimeZone to UTC
         calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);

         if (fromTimeZone.inDaylightTime(calendar.getTime()))
             calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);

         // UTC to TO TimeZone
         calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());

         if (toTimeZone.inDaylightTime(calendar.getTime()))
             calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());

         return calendar.getTime();
     }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockTime frame = new ClockTime();
					//frame.pack();
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
	public ClockTime() {
		setTitle("Clock");
		 Timer t = new Timer(100, new ActionListener() {  
             public void actionPerformed(ActionEvent e) {  
                 repaint(); 
                
             }  
         });  
		 
		 
         //t.start();  
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		display_1.setBounds(118, 10, 198, 61);
		display_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		contentPane.add(display_1);
		
		 displayMethod();
		
		
	
		
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
         c.ipady = 20;
    	dropdown.setBounds(56, 76, 321, 43);
    	dropdown.setFont(new Font("Tahoma", Font.PLAIN, 20));
    
    	contentPane.add(dropdown);
    	
    	dropdown.addActionListener(this);	
    	
		
	}


	private void displayMethod() {
		int aHour;  
	     int bMinute;  
	     int cSecond; 
		
		 Date rite = offsetTimeZone(new Date(), "Iran", timezone);  
        
		
		 	formatter.applyPattern("s");
	        cSecond = Integer.parseInt(formatter.format(rite));
	        formatter.applyPattern("m");
	        bMinute = Integer.parseInt(formatter.format(rite));
	        formatter.applyPattern("h");
	        aHour = Integer.parseInt(formatter.format(rite));
      
	        
	        hour = aHour;
	        minute = bMinute;
	        second = cSecond;
	       
       display_1.setText(hour+":"+minute+":"+second);
		contentPane.add(display_1);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object instance = dropdown.getSelectedItem();
	       timezone = instance.toString();
	       displayMethod();
	       
		repaint();
		
	}
	
}