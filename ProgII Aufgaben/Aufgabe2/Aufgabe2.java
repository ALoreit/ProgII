package Aufgabe2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Aufgabe2 extends JFrame{
	Container c;
	private JButton jb1;
	private JComboBox<String> jcb;
	private JLabel jl;
	private Date datum;
	public static SimpleDateFormat kurz;
	public static SimpleDateFormat mittel;
	public static SimpleDateFormat lang;
	
	public Aufgabe2() {
		datum = new Date();
		kurz = new SimpleDateFormat("dd.MM.yyyy" + "(" + "HH:mm" + ")");
		mittel = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		lang = new SimpleDateFormat("EE, dd.MM.yyyy HH:mm");
		c = getContentPane();
		c.setLayout(new BorderLayout());
		
		jb1 = new JButton("Anzeige aktuallisieren");
		jb1.addActionListener(new Knopfhorcher());
		
		jl = new JLabel();
		jl.setText("Datum und Uhrzeit:   ");
		
		jcb = new JComboBox<String>();
		jcb.addItem("Tag, Datum und Uhrzeit");
		jcb.addItem("Datum und Uhrzeit mit Sekunden");
		jcb.addItem("Datum mit Jahr und Uhrzeit");
		
		c.add(jb1, BorderLayout.SOUTH);
		c.add(jl, BorderLayout.CENTER);
		c.add(jcb, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		Aufgabe2 fenster = new Aufgabe2();
		fenster.setTitle("Aufgabe2");
		fenster.setSize(300, 150);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Knopfhorcher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selected = jcb.getSelectedIndex();
			switch(selected) {
			case 0:
				jl.setText("Datum und Uhrzeit    " + lang.format(datum));
				break;
			case 1:
				 jl.setText("Datum und Uhrzeit    " + mittel.format(datum));
				 break;
			case 2:
				jl.setText("Datum und Uhrzeit    " + kurz.format(datum));
			}
		}
		
	}
}
