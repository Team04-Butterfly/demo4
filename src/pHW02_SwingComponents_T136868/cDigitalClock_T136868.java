/**
 * 
 */
package pHW02_SwingComponents_T136868;

import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;


public class cDigitalClock_T136868 extends JFrame {
	JLabel time;

	cDigitalClock_T136868() {
		setSize(250, 250);
		setTitle("T136868-Digital Clock");
		setLocation(125, 125);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());

		time = new JLabel("");
		time.setFont(new Font("",Font.BOLD, 40));
		time.setForeground(Color.BLACK);
		add(time);
		new Thread(new Runnable() {
			public void run() {
				try {
					updateTime();
				} catch (Exception ie) {
				}
			}
		}).start();
	}

	public void updateTime() {
		try {
			while (true) {
				time.setText(new SimpleDateFormat("hh:mm:ss ")
						.format(new java.util.Date()));
				Thread.currentThread().sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Exception in Thread Sleep : " + e);
		}
	}

	public static void main(String[] args) {
		JFrame obj = new cDigitalClock_T136868();
		obj.setVisible(true);
	}
}