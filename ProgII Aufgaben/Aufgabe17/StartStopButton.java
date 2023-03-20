package Aufgabe17;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class StartStopButton extends JButton{
	
	public StartStopButton(Color color) {
		this.setBackground(color);
		this.setFont(new Font("Arial", Font.BOLD, 25));	
		this.setText("START");
	}
	
	public boolean isStart() {
		return this.getText().equals("START");
	}
	
	public void switchText() {
		if(isStart()) {
			this.setText("STOPP");
		}else {
			this.setText("START");
		}
	}
	
}
