package Aufgabe4;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Aufgabe4 extends JFrame{
	private Container c;
	private Button add;
	private Button sub;
	private Button mul;
	private Button div;
	private Button del;
	private JTextField inp1;
	private JTextField inp2;
	private JLabel calc;
	private JLabel equal;
	private JLabel result;
	
	public Aufgabe4() {
		c = getContentPane();
		c.setLayout(new GridLayout(2, 5));
		
		add = new Button("Addire");
		add.addActionListener(new OperatorListener('+'));
		sub = new Button("Subtrahiere");
		sub.addActionListener(new OperatorListener('-'));
		mul = new Button("Multipliziere");
		mul.addActionListener(new OperatorListener('*'));
		div = new Button("Dividiere");
		div.addActionListener(new OperatorListener('/'));
		del = new Button("Loesche alles");
		del.addActionListener(new OperatorListener('1'));
		inp1 = new JTextField();
		inp2 = new JTextField();
		calc = new JLabel();
		equal = new JLabel("=");
		result = new JLabel();
		
		c.add(inp1);
		c.add(calc);
		c.add(inp2);
		c.add(equal);
		c.add(result);
		c.add(add);
		c.add(sub);
		c.add(mul);
		c.add(div);
		c.add(del);
		
		
	}
	
	public static void main(String[] args) {
		Aufgabe4 fenster = new Aufgabe4();
		fenster.setTitle("Aufgabe4");
		fenster.setSize(600, 100);
		fenster.setVisible(true);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class OperatorListener implements ActionListener{
		private char action; 
		
		public OperatorListener(char action){
			this.action = action;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(action == '1') {
				inp1.setText("");
				inp2.setText("");
				result.setText("");
			}else {
			
			try {
				double num1 = Double.parseDouble(inp1.getText());
				double num2 = Double.parseDouble(inp2.getText());
				
				double ergebnis = 0;
				
				switch(action) {
				case '+':
					ergebnis = num1 + num2;
					calc.setText("+");
					result.setText("" + ergebnis);
					break;
				case '-':
					ergebnis = num1 - num2;
					calc.setText("-");
					result.setText("" + ergebnis);
					break;
				case '*':
					ergebnis = num1 * num2;
					calc.setText("*");
					result.setText("" + ergebnis);
					break;
				case '/':
					ergebnis = num1/num2;
					calc.setText("/");
					result.setText("" + ergebnis);
					break;
				}
			} catch (Exception e2) {
				result.setText("Invalid Input");
				new WrongInputException();
			}

			}
			
			
		}
		
	}
	
	
	
}
