package projects;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import demoJava.CountDownTimer3;
import demoJava.DigitalClock;
import demoJava.DigitalClockSample;
import demoJava.SimpleClock;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Font;

public class Main implements ActionListener {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Digital Clock");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem jItemClock = new JMenuItem("Clock");
		jItemClock.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(jItemClock);
		jItemClock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClockTime clock = new ClockTime();
				clock.setVisible(true);
			}
			
		});
		
		JMenuItem jItemStopWatch = new JMenuItem("StopWatch");
		jItemStopWatch.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(jItemStopWatch);
		jItemStopWatch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StopWatch watch = new StopWatch();
				watch.setVisible(true);
				
			}
		
		});
		
		
		JMenuItem jItemTimer = new JMenuItem("Timer");
		jItemTimer.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(jItemTimer);
		jItemTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimerCount clock = new TimerCount();
				clock.setVisible(true);
				
			}
			
			
		});
		
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
	


