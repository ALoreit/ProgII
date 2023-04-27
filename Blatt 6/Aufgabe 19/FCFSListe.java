package UEB6A19;

public class FCFSListe implements WarteSchlange {
	private ZPatient first = new ZPatient("First", 1999);
	private ZPatient last = new ZPatient("Last", 1999);
	
	public FCFSListe() {
		first.next = last;
	}

	@Override
	public void anmelden(ZPatient p) {
		last.next = p;
		last = p;
	}

	@Override
	public ZPatient derNaechsteBitte() {
		
		ZPatient dran = first;
		first = first.next;
		
		return dran;
	}

}
