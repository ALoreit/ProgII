package Aufgabe5;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Aufgabe4.Aufgabe4;

public class Aufgabe5 extends JFrame {
	Container c;
	JLabel euro;
	JTextField inp1;
	JLabel result;
	JComboBox<String> to;

	public Aufgabe5() {
		c = getContentPane();
		c.setLayout(new GridLayout(4, 1));
		
		euro = new JLabel("Euro");
		inp1 = new JTextField();
		result = new JLabel();
		to = new JComboBox<String>();
		to.addItem("Deutsche Mark");
		to.addItem("Oestereichischer Schilling");
		to.addItem("Franzoesische Franc");
		to.addItem("Belgische Franc");
		to.addItem("Luxemburgische Franc");
		to.addItem("Niederlaendische Gulden");
		to.addItem("Spanische Peseten");
		to.addItem("Portugiesische Escudos");
		to.addItem("Italienische Lire");
		to.addItem("Finnische Mark");
		to.addItem("Irische Pfund");
		to.addItem("Griechische Drachmen");
		inp1.addKeyListener(new EnterKeyListener());
		
		c.add(euro);
		c.add(inp1);
		c.add(to);
		c.add(result);
	}

	public static void main(String[] args) {
		Aufgabe5 fenster = new Aufgabe5();
		fenster.setTitle("Aufgabe5");
		fenster.setSize(300, 150);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class EnterKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				int i = to.getSelectedIndex();
				switch(i) {
				case 0:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 0)));
					break;
				case 1:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 1)));
					break;
				case 2:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 2)));
					break;
				case 3:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 3)));
					break;
				case 4:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 4)));
					break;
				case 5:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 5)));
					break;
				case 6:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 6)));
					break;
				case 7:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 7)));
					break;
				case 8:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 8)));
					break;
				case 9:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 9)));
					break;
				case 10:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 10)));
					break;
				case 11:
					result.setText("" + (EuroConverter.convertFromEuro(Double.parseDouble(inp1.getText()), 11)));
					break;
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
