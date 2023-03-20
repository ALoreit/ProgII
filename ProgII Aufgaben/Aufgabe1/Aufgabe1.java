package Aufgabe1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Aufgabe1 extends JFrame {
	Container c;
	JButton jb1;

	public Aufgabe1() {
		c = getContentPane();
		c.setLayout(new FlowLayout());

		jb1 = new JButton("Drueck mich");
		jb1.addActionListener(new Knopfhorcher());
		c.addMouseListener(new FensterHorcher());
		
		c.add(jb1);
	}

	public static void main(String[] args) {
		Aufgabe1 f = new Aufgabe1();
		f.setTitle("B3-Testprogramm");
		f.setSize(250, 150);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class Knopfhorcher implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setBackground(Color.BLACK);
		}

	}
	
	class FensterHorcher implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			c.setBackground(Color.WHITE);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
