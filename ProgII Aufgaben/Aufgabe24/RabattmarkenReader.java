package Aufgabe24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RabattmarkenReader {
	public static void main(String[] args) {
		try {
			File f = new File("IO/Rabattmarke.dat");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

			while(true) {
				try {
					Rabattmarke a = (Rabattmarke) ois.readObject();
					if(a == null) {
						break;
					}
					System.out.println(a.toString());
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
