package UEB6A18;

import java.util.*;

import ProgIOTools.IOTools;

public class EratosthenesSieb {
	
	public static Set<Integer> sieb(){
		
		int n = IOTools.readInt("Primzahlen von 2 bis: ");
		int p = 2;
		Set<Integer> T = new TreeSet<>();
		Set<Integer> S = new TreeSet<>();
		
		for(int i = 2; i < n; i++) {
			T.add(i);
		}

		do {
			for(int i = 2; i * p < n; i++) {
				S.add(i * p);
			}
			
			if(p == 2) {
				p = 3;
			}else {
				p += 2;
			}
			
		}while((p*p) <= n);
		
		Iterator<Integer> it = S.iterator();
		
		while(it.hasNext()) {
			int num = it.next();
			if(T.contains(num)) {
				T.remove(num);
			}
		}
		
		
		return T;
	}

	public static void main(String[] args) {
		System.out.println(sieb());
	}
}
