package Aufgabe22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ProgIOTools.IOTools;

public class Aufgabe22 {

	public static void main(String[] args) throws IOException {
		File f = new File("IO/" + IOTools.readLine("Datei-Name: "));
		int zeile = IOTools.readInt("Zeilen-Nummer: ");
		String text = IOTools.readLine("Neue Textzeile: ");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			File blabla = new File("IO/blabla.txt");
			if (blabla.exists() == false) {
				blabla.createNewFile();
			} else {
				blabla.delete();
				blabla.createNewFile();
			}
			BufferedWriter writerBlaBla = new BufferedWriter(new FileWriter(blabla));

			if (zeile <= 0) {
				writerBlaBla.write(text);
				writerBlaBla.newLine();
				while (true) {
					String str = reader.readLine();
					if(str == null) {
						break;
					}
					writerBlaBla.write(str);
					writerBlaBla.newLine();
				}
			} else {
				while (true) {
					int counter = 0;
					while(counter < zeile) {
						String str = reader.readLine();
						
						if(str == null) {
							break;
						}
						writerBlaBla.write(str);
						counter++;
						writerBlaBla.newLine();
					}
					writerBlaBla.write(text);
					writerBlaBla.newLine();
					String str = reader.readLine();

					if(str == null) {
						break;
					}
					writerBlaBla.write(str);
					writerBlaBla.newLine();
				}
			}
			reader.close();
			writerBlaBla.close();
			
			BufferedReader readerBlaBla = new BufferedReader(new FileReader(blabla));
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			while (true) {
				String str = readerBlaBla.readLine();
				if(str == null) {
					break;
				}
				writer.write(str);
				writer.newLine();
			}
			writer.close();
			readerBlaBla.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
