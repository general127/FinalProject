package projects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;

public class StopWatch extends JFrame implements ActionListener
{
	Timer t;
	JOptionPane dialog;
	JLabel display;
	DecimalFormat df;
	JPanel controlPanel;
	JButton ssBtn,reBtn,prBtn,about;
	public StopWatch()
	{
		setTitle("StopWatch");
		ButtonPerformed btnPerform=new ButtonPerformed();
		ssBtn=new JButton("Start");
		ssBtn.setBounds(70, 79, 85, 23);
		reBtn=new JButton("Reset");
		reBtn.setBounds(249, 79, 76, 23);
		prBtn=new JButton("Pause");
		prBtn.setBounds(164, 79, 75, 23);
		about=new JButton("About");
		about.setBounds(335, 79, 85, 23);
		prBtn.setEnabled(false);
		controlPanel=new JPanel();
		df=new DecimalFormat("00");
		dialog=new JOptionPane();
		t=new Timer(10,this);
		getContentPane().setLayout(new BorderLayout());
		controlPanel.setLayout(null);
		controlPanel.add(ssBtn);//Start/Stop
		controlPanel.add(prBtn);//Pause/Resume
		controlPanel.add(reBtn);//Reset
		controlPanel.add(about);
		getContentPane().add(controlPanel,BorderLayout.CENTER);
		display=new JLabel();
		display.setBounds(98, 11, 265, 28);
		controlPanel.add(display);
		display.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		display.setText("Elapse : "+df.format(hour)+" : "+df.format(minute)
		+" : "+df.format(second)+" : "+df.format(csecond));
		display.setFont(new Font("Arial",Font.BOLD,24));
		prBtn.addActionListener(btnPerform);
		ssBtn.addActionListener(btnPerform);
		reBtn.addActionListener(btnPerform);
		about.addActionListener(btnPerform);
		setSize(471,277);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void startTimer()
	{
		t.start();
	}
	void stopTimer()
	{
		t.stop();
		csecond=0;
		second=0;
		minute=0;
		hour=0;
	}
	void pauseTimer()
	{
		t.stop();
	}
	void resumeTimer()
	{
		t.start();
	}
	void resetTimer()
	{
		csecond=0;
		second=0;
		minute=0;
		hour=0;
		display.setText("Elapse : "+df.format(hour)+" : "+df.format(minute)
		+" : "+df.format(second)+" : "+df.format(csecond));
	}
	private int csecond=0;
	private int second=0;
	private int minute=0;
	private int hour=0;
	private boolean isPause=true;
	private boolean isStart=true;
	public void actionPerformed(ActionEvent e){
		csecond++;
		if(csecond==100)
		{
			second++;
			csecond=0;
		}
		if(second==60){
			minute++;
			second=0;
		}
		if(minute==60){
			hour++;
			minute=0;
		}

		display.setText("Elapse : "+df.format(hour)+" : "+df.format(minute)
		+" : "+df.format(second)+" : "+df.format(csecond));
	}
	private class ButtonPerformed implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==ssBtn)
			{
				if(isStart)
				{
					startTimer();
					isStart=false;
					ssBtn.setText("Stop");
					prBtn.setEnabled(true);

				}
				else
				{
					isStart=true;
					ssBtn.setText("Start");
					stopTimer();
					isPause=true;
					prBtn.setText("Pause");
					prBtn.setEnabled(false);
				}
			}
			if(e.getSource()==prBtn)
			{
				if(isPause)
				{
					prBtn.setText("Resume");
					pauseTimer();
					isPause=false;
				}
				else
				{
					prBtn.setText("Pause");
					startTimer();
					isPause=true;
				}
			}
			if(e.getSource()==reBtn)
			{
				resetTimer();
			}
			if(e.getSource()==about)
			{
				dialog.showMessageDialog(null,"Muhammad Suleiman");
			}
		}
	}
	public static void main(String args[])
	{
		StopWatch watch=new StopWatch();

	}

}