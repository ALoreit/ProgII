package Algorithmen_Datenstrukturen.Aufgabe8_9;

public class TestListeF {
	public static void main(String[] args) {
		ListeF f = new ListeF(5);
		f.insert(7);
		f.insert(6);
		f.insert(15);
		f.insert(1);
		f.insert(5);
		System.out.println(f.toString());
		f.loescheMin();
		System.out.println(f.toString());
	}
}
