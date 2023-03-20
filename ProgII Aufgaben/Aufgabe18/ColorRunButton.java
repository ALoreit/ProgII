package Aufgabe18;

import javax.swing.JButton;

public class ColorRunButton extends JButton implements Runnable{
	private static volatile boolean running;
	private volatile static boolean zeigtBuchstabe;
	Thread t;

	public ColorRunButton() {

	}

	public void change(boolean buchstabe) {
		this.zeigtBuchstabe = buchstabe;
		if (this.running) {
			this.running = false;
		} else {
			this.running = true;
			t = new Thread(this);
			t.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			int i = (int) (Math.random() * 10);
			if(zeigtBuchstabe) {
				char c = (char)(97 + i);
				this.setText("" + c);
			}else {
				this.setText("" + i);
			}
		}
	}
}
