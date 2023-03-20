package Aufgabe3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Aufgabe3 extends JFrame{
	private Container c;
	private ButtonGroup bg;
	private JRadioButton jrb1;
	private JRadioButton jrb2;
	private JRadioButton jrb3;
	private Button b1;
	private Button b2;
	private Button b3;
	
	
	public Aufgabe3() {
		c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		
		b1 = new Button();
		b1.setBackground(Color.RED);
		b2 = new Button();
		b2.setBackground(Color.BLACK);
		b3 = new Button();
		b3.setBackground(Color.BLACK);

		
		
		jrb1 = new JRadioButton();
		jrb1.setSelected(true);
		jrb1.addActionListener(e -> {
			b1.setBackground(Color.RED);
			b2.setBackground(Color.BLACK);
			b3.setBackground(Color.BLACK);
		});
		jrb2 = new JRadioButton();
		jrb2.addActionListener(e ->{
			b2.setBackground(Color.YELLOW);
			b1.setBackground(Color.BLACK);
			b3.setBackground(Color.BLACK);
		});
		jrb3 = new JRadioButton();
		jrb3.addActionListener(e -> {
			b3.setBackground(Color.GREEN);
			b2.setBackground(Color.BLACK);
			b1.setBackground(Color.BLACK);
		});
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		
		c.add(jrb1);
		c.add(b1);
		c.add(jrb2);
		c.add(b2);
		c.add(jrb3);
		
		
		c.add(b3);
	}
	
	public static void main(String[] args) {
		Aufgabe3 fenster = new Aufgabe3();
		fenster.setTitle("Aufgabe3");
		fenster.setSize(300, 150);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class KnopfHorcher implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
