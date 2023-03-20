package Aufgabe18;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Aufgabe17.AutomatFrame;

public class LaufFrame extends JFrame{
	private Container c;
	private ColorRunButton crb1;
	private ColorRunButton crb2;
	private JCheckBox jcb;
	private JComboBox<String> jcbb;
	
	public LaufFrame() {
		c = getContentPane();
		c.setLayout(new GridLayout(2, 2));
		
		this.crb1 = new ColorRunButton();
		this.crb2 = new ColorRunButton();
		this.jcb = new JCheckBox();
		this.jcbb = new JComboBox<String>();
		
		crb1.addActionListener(new KnopfListener(crb1));
		crb2.addActionListener(new KnopfListener(crb2));
		
		jcbb.addItem("graue Schrift");
		jcbb.addItem("schwarze Schrift");
		
		c.add(crb1);
		c.add(crb2);
		c.add(jcb);
		c.add(jcbb);
	}
	
	class KnopfListener implements ActionListener{
		private ColorRunButton button;
		
		public KnopfListener(ColorRunButton b) {
			this.button = b;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = jcbb.getSelectedIndex();
			if (i == 0) {
				button.setForeground(Color.GRAY);
			}else {
				button.setForeground(Color.BLACK);
			}
			if(jcb.isSelected()) {
				button.change(true);
			}else {
				button.change(false);
			}
		}
		
	}
	
	public static void main(String[] args) {
		LaufFrame fenster = new LaufFrame();
		fenster.setTitle("Lauf");
		fenster.setSize(400, 200);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
