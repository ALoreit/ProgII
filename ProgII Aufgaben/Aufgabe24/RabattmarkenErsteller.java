package Aufgabe24;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ProgIOTools.IOTools;

public class RabattmarkenErsteller {
	public static void main(String[] args) {

		try {
			int anzahl = IOTools.readInt("Anzahl der zu erzeugenden Rabattmarken: ");
			File f = new File("IO/Rabattmarke.dat");
			if(f.exists() == false) {
				f.createNewFile();
			}else {
				f.delete();
				f.createNewFile();
			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			for (int i = 0; i < anzahl; i++) {
				Rabattmarke r = new Rabattmarke(i, IOTools.readLine("Name des Besitzers:"),
						IOTools.readInt("Customer-Id"), IOTools.readInt("Rabatt Wert der Marke:"));
				oos.writeObject(r);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
