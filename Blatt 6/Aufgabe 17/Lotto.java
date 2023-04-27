package UEB6A17;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
	
	public static Set<Integer> ziehen() {
		Set<Integer> s1 = new HashSet<Integer>();
		while(s1.size() < 7) {
			s1.add((int) (Math.random()*49));
		}
		return s1;
	}
	
	public static void main(String[] args) {
		System.out.println(ziehen());
	}
}
