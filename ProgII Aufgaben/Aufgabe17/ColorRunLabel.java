package Aufgabe17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorRunLabel extends JLabel implements Runnable{
	private volatile boolean running;
	Thread t = new Thread(this);
	
	public ColorRunLabel(Color color) {
		this.setBackground(color);
		this.setFont(new Font("Arial", Font.BOLD, 50));
	}
	
	public void start() {
		this.running = true;
		t.start();
	}
	
	public void stopp() {
		this.running = false;
	}
	
	@Override
	public void run() {
		while(running) {
			int i = (int) (Math.random() * 10);
			this.setText("" + i);
			try {
				Thread.sleep(10);
			} catch (Exception e) {}
		}
	}
	
}
