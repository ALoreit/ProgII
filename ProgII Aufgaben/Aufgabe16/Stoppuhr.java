package Aufgabe16;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ProgIOTools.IOTools;

public class Stoppuhr {
	private static Scanner scan = new Scanner(System.in);
	private static boolean running = true;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Stoppuhr starten mit Eingabetaste!");
		IOTools.readLine();
		Date now = new Date();
		System.out.println("Startzeitpunkt: " + now);
		SecondThread thread = new SecondThread();
		thread.start();
		System.out.println("Zum beenden Enter drücken");
		IOTools.readLine();
		running = false;
		Date ende = new Date();
		System.out.println("Stoppzeitpunkt: " + ende);
		System.out.println("Gesamtlaufzeit: " + (now.compareTo(ende)));

	}

	static class SecondThread implements Runnable {
		private Date now;
		private SimpleDateFormat zeitFormat = new SimpleDateFormat("hh.mm.ss");
		private Thread t = new Thread(this);

		public void start() {
			t.start();
		}

		@Override
		public void run() {
			while (running) {
				try {
					now = new Date();
					System.out.println(zeitFormat.format(now));
					Thread.sleep(1000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
