package Aufgabe17;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		c.setLayout(new GridLayout(2, 3));
		this.label1 = new ColorRunLabel(Color.RED);
		this.label2 = new ColorRunLabel(Color.YELLOW);
		this.label3 = new ColorRunLabel(Color.GREEN);
		this.ssb1 = new StartStopButton(Color.RED);
		this.ssb2 = new StartStopButton(Color.YELLOW);
		this.ssb3 = new StartStopButton(Color.GREEN);
		
		ssb1.addActionListener(new KnopfHorcher(ssb1, label1));
		ssb2.addActionListener(new KnopfHorcher(ssb2, label2));
		ssb3.addActionListener(new KnopfHorcher(ssb3, label3));
		
		c.add(label1);
		c.add(label2);
		c.add(label3);
		c.add(ssb1);
		c.add(ssb2);
		c.add(ssb3);
	}
	
	class KnopfHorcher implements ActionListener{
		private StartStopButton button;
		private ColorRunLabel label;
		
		public KnopfHorcher(StartStopButton b, ColorRunLabel l) {
			this.button = b;
			this.label = l;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(this.button.isStart()){
				this.button.switchText();
				this.label.start();
			}else {
				this.button.switchText();
				this.label.stopp();
			}
		}
		
	}
	
	public static void main(String [] args) {
		AutomatFrame fenster = new AutomatFrame();
		fenster.setTitle("Spielautomat");
		fenster.setSize(400, 200);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
