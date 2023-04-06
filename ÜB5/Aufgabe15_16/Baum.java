package Algorithmen_Datenstrukturen.Aufgabe15_16;

import ProgIOTools.IOTools;

public class Baum {
	private int wert; // Inhalt
	private Baum links; // Verweis auf linken Teilbaum
	private Baum rechts; // Verweis auf rechten Teilbaum

	public Baum(int x) {
		wert = x;
	}

	public void insert(int x) {
		if (x < wert) { // im linken Ast einfügen

			if (links == null) {
				links = new Baum(x);
			} else {
				links.insert(x);
			}
		} else { // im rechten Ast einfügen

			if (rechts == null) {
				rechts = new Baum(x);
			} else {
				rechts.insert(x);
			}
		}
	}

	public int maxIt() {
		if (rechts != null) {
			Baum hilf = rechts;
			while(hilf.rechts != null) {
				hilf = hilf.rechts;
			}
			return hilf.wert;	
		} else {
			return wert;
		}
	}

	public int max(Baum b) {
		if(b.rechts != null) {
			return max(b.rechts);
		}
		return wert; // rekursiv
	}
	
	public int anzahlBlaetter(Baum b) {
		
		if(b == null) {
			return 0;
		}
		
		if(b.links == null && b.rechts == null) {
			return 1;
		}
		
		int anzahlLinks = anzahlBlaetter(b.links);
		int anzahlRechts = anzahlBlaetter(b.rechts);
		
		return anzahlLinks + anzahlRechts;
	}

	public int min() {
		if (links == null) {
			return wert;
		} else
			return links.min();
	}

	public String toString() { // Inorder-Traversierung
		String s = "";
		if (links != null) {
			s = s + links.toString();
			s = s + ", ";
		}
		s = s + wert;
		if (rechts != null) {
			s = s + ", ";
			s = s + rechts.toString();
		}
		return s;
	}

	public String toPostorder(Baum b) {
		String s ="";
		if (b != null) {
	        s += toPostorder(b.links);
	        s += toPostorder(b.rechts);
	        s += b.wert + " ";
	    }
		
		return s;
	}

	public static void main(String[] args) {
		System.out.println("Beliebig viele int-Werte " + "eingeben (Wert 0 fuer Abbruch):");

		int n = IOTools.readInteger();
		Baum b = new Baum(n);

		while (n != 0) {
			n = IOTools.readInteger();
			b.insert(n);
		}

		System.out.println("Sortierte Liste: " + b);
		System.out.println("Max: " + b.maxIt());
		System.out.println("Max: " + b.max(b));
		System.out.println("Min: " + b.min());
		System.out.println("Postorder Liste: " + b.toPostorder(b));
		System.out.println("Anzahl Blaetter: " + b.anzahlBlaetter(b));
	}
}