package Algorithmen_Datenstrukturen.Aufgabe8_9;

public class ListeF <T extends Comparable<T>>{
	private T[] element;
	private int lastIndex = 0;

	public ListeF(int laenge) {
		element = (T[]) new Comparable[laenge];
		lastIndex = -1;
	}

	public void insert(T o) {
		if (lastIndex == element.length - 1)
			throw new RuntimeException("Liste ist bereits voll!");
		lastIndex++;
		element[lastIndex] = o;
	}

	public void insert(T o, int k) {
		if (lastIndex == element.length - 1)
			throw new RuntimeException("Liste ist bereits voll!");
		if (k < 0 || k >= element.length)
			throw new RuntimeException("Position unzulässig!");
		if (k > lastIndex)
			insert(o);
		else {
			lastIndex++;
			for (int i = lastIndex; i > k; i--)
				element[i] = element[i - 1];
			element[k] = o;
		}
	}

	public void remove(int k) {
		if (k < 0 || k >= element.length)
			throw new RuntimeException("Position unzulässig!");
		if (k < lastIndex) {
			for (int i = k; i < lastIndex; i++)
				element[i] = element[i + 1];
			element[lastIndex] = null;
			lastIndex--;
		}
	}
	
	public void loescheErst() {
		for(int i = 0; i < lastIndex; i++) {
			element[i] = element[i+1];	
		}
		element[lastIndex] = null;
		lastIndex--;
	}
	
	public void loescheMin() {
		int min = 0; //Index des kleinsten elements in der Liste
		for(int i = 1; i < lastIndex; i++) {
			if( element[min].compareTo(element[i]) > 0) {
				min = i;
			}
		}
		remove(min);
		
	}

	public String toString() {
		String s = "( ";
		for (int i = 0; i < lastIndex; i++)
			s = s + element[i] + ", ";
		if (lastIndex != 1)
			s = s + element[lastIndex];
		return s + ")";
	}
}
