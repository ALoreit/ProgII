package Aufgabe17;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class AutomatFrame extends JFrame{
	private Container c;
	ColorRunLabel label1; 
	ColorRunLabel label2;
	ColorRunLabel label3;
	StartStopButton ssb1;
	StartStopButton ssb2;
	StartStopButton ssb3;
	
	public AutomatFrame() {
		c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		this.label1 = new ColorRunLabel(Color.RED);
		this.label2 = new ColorRunLabel(Color.YELLOW);
		this.label2 = new ColorRunLabel(Color.GREEN);
		this.ssb1 = new StartStopButton(Color.RED);
		this.ssb2 = new StartStopButton(Color.YELLOW);
		this.ssb3 = new StartStopButton(Color.RED);
	}
}
