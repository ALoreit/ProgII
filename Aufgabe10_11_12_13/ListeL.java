package Algorithmen_Datenstrukturen.Aufgabe10_11_12_13;

public class ListeL<I extends Comparable<I>> {

	static class ElementL<K> {
		private K inhalt; // Inhalt des Listenelements
		private ElementL<K> next; // Verweis auf den Nachfolger

		public ElementL(K o) {
			inhalt = o;
			next = null;
		}
	}

	private ElementL<I> head; // Referenz auf den Anfang der Liste

	public ListeL() {
		head = null;
	}

	public ListeL(I o) {
		head = new ElementL<I>(o);
	}

	public ElementL<I> insert(I o) { // am Anfang einfügen
		ElementL<I> newEl = new ElementL<I>(o);
		if (head == null) { // Liste ist noch leer
			head = newEl;
		} else {
			newEl.next = head;
			head = newEl;
		}
		return newEl;
	}

	public ElementL<I> insert(I o, ElementL<I> pred) { // nach pred (Vorgänger) einfügen
		ElementL<I> newEl = new ElementL<I>(o);
		if (pred == null) { // am Anfang einfügen
			newEl.next = head;
			head = newEl;
		} else { // nach pred (Vorgänger) einfügen
			newEl.next = pred.next;
			pred.next = newEl;
		}
		return newEl;
	}

	public void remove(ElementL<I> pred) { // Element nach pred (Vorgänger) löschen
		if (pred == null) // erstes Element löschen
			head = head.next;
		else if (pred.next != null) // Element nach pred (Vorgänger) löschen
			pred.next = pred.next.next;
	}

	public int find1(ElementL<I> o) {
		int index = -1;
		if (head.inhalt.equals(o.inhalt)) {
			index = 0;
		} else {
			ElementL naechstes = head.next;
			int i = 1;
			while (naechstes.inhalt.equals(o.inhalt) == false) {
				naechstes = naechstes.next;
				i++;
			}
			index = i;
		}
		return index;
	}

	public ElementL<I> insertE(I o, ElementL<I> pos) {
		ElementL<I> newEl = new ElementL<I>(o);
		if (pos == null) {
			head = newEl;
		} else {
			ElementL<I> pred = head;
			while (pred.next != pos) {
				pred = pred.next;
			}
			newEl.next = pos;
			pred.next = newEl;
		}

		return newEl;
	}

	public void sort1() {
		ElementL<I> pos = head;
		while (pos != null && pos.next != null) {
			ElementL<I> min = pos;
			ElementL<I> naechstes = pos.next;
			while (naechstes != null) {
				if (naechstes.inhalt.compareTo(min.inhalt) < 0) {
					min = naechstes;
				}
				naechstes = naechstes.next;
			}
			I help = min.inhalt;
			min.inhalt = pos.inhalt;
			pos.inhalt = help;
			pos = pos.next;

		}
	}
	
	public void aushaengen() {
		if(head != null && head.next != null) {
			ElementL<I> kopf = head;
			head = kopf.next;
			ElementL<I> naechstes = head;
			while(naechstes.next != null) {
				if(naechstes.inhalt.compareTo(kopf.inhalt) > 0) {
					kopf.next = naechstes.next;
					naechstes.next = kopf; 
					return;
				}
				naechstes = naechstes.next;
			}
			naechstes.next = kopf;
			head = naechstes;
		}
		return;
	}

	public String toString() {
		String s = "(";
		ElementL<I> help = head;
		while (help != null && help.next != null) {
			s = s + help.inhalt + ", ";
			help = help.next;
		}
		if (help != null)
			s = s + help.inhalt;
		return s + ")";
	}

	// Test

	public static void main(String[] args) {
		ListeL<Integer> l = new ListeL<Integer>();
		l.insert(0);
		ElementL<Integer> eins = l.insert(new Integer(1));
		ElementL<Integer> sieben = l.insert(new Integer(7), eins);
		l.insert(3);
		System.out.println(l);
		l.insert(2, eins); // nach eins einfügen
		System.out.println(l);
//		l.remove(eins); // Nachfolger von eins löschen
//		System.out.println(l);
		System.out.println(l.find1(sieben));
		l.insertE(8, eins);
		System.out.println(l);
		l.aushaengen();
		System.out.println(l);
		l.sort1();
		System.out.println(l);
	}

}