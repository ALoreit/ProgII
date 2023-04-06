package Algorithmen_Datenstrukturen.Aufgabe14;

public class ListeDL<T> {

	private static class ElementDL<E> {
		private E element; // Inhalt des Listenelements
		private ElementDL<E> next; // Verweis auf den Nachfolger
		private ElementDL<E> prev; // Verweis auf den Vorgänger

		public ElementDL(E o) {
			element = o;
			next = null;
			prev = null;
		}
	}

	private ElementDL<T> head; // Referenz auf den Anfang der Liste
	private ElementDL<T> tail; // Referenz auf das Ende der Liste

	public ListeDL() {
		head = null;
		tail = null;
	}

	public ListeDL(T o) {
		head = new ElementDL<T>(o);
		tail = head;
	}

	// Methode, um o am Ende einzufügen
	public ElementDL<T> insert(T o) {
		ElementDL<T> neu = new ElementDL<T>(o);
		if (tail != null) {
			tail.next = neu;
			neu.prev = tail;
			tail = neu;
		} else {
			tail = neu;
			head = neu;
		}

		return tail;
	}

	// Methode, um o an der Postion pos einfügen
	public ElementDL<T> insert(T o, ElementDL<T> pos) {
		ElementDL<T> newEl = new ElementDL<T>(o);
		if (pos == head) {
			pos.prev = newEl;
			newEl.next = pos;
			head = newEl;
		} else if (pos == tail) {
			pos.prev.next = newEl;
			newEl.prev = pos.prev;
			pos.prev = newEl;
			newEl.next = pos;
		} else {
			pos.prev.next = newEl;
			newEl.prev = pos.prev;
			pos.prev = newEl;
			newEl.next = pos;
		}
		return newEl;
	}

	// Element e löschen
	public void remove(ElementDL<T> e) {
		if (e.prev != null && e.next != null) {
			e.prev.next = e.next;
			e.next.prev = e.prev;
		} else if (e == tail) {
			tail = e.prev;
			e.prev.next = null;
		} else if (e == head) {
			e.next.prev = null;
			head = e.next;
		}

	}

	public String toString() {
		String s = "( ";
		ElementDL<T> hilf = head;
		while (hilf != null) {
			s = s + hilf.element + " ";
			hilf = hilf.next;
		}
		return s + ")";
	}

	// Test
	public static void main(String[] args) {
		ListeDL<Integer> l = new ListeDL<Integer>();
		l.insert(new Integer(0));
		ElementDL<Integer> eins = l.insert(new Integer(1));
		l.insert(new Integer(3));
		System.out.println(l);
		l.insert(new Integer(2), eins); // vor eins einfügen
		System.out.println(l);
//		l.remove(eins); // Nachfolger von eins löschen
//		System.out.println(l);
	}

}