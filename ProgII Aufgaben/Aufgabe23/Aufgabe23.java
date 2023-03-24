package Aufgabe23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.stream.Stream;

import ProgIOTools.IOTools;

public class Aufgabe23 {
	public static void main(String[] args) {
		try {
			File source = new File("IO/" + IOTools.readLine("Name der Quelldatei: "));
			File numbers = new File("IO/" + IOTools.readLine("Name der Zahl Ausgabedatei: "));
			File rest = new File("IO/" + IOTools.readLine("Name der Rest-Ausgabedatei: "));
			StreamTokenizer st = new StreamTokenizer(new FileReader(source));
			//Zeilenumbrüche erkennen
			st.eolIsSignificant(true);
			PrintWriter pwN = new PrintWriter(numbers);
			PrintWriter pwR = new PrintWriter(rest);
			
			while(true) {
				int i = st.nextToken();
				if(i == StreamTokenizer.TT_EOF) {
					break;
				}
				if(i == StreamTokenizer.TT_NUMBER) {
					pwN.write(Double.toString(Math.abs(st.nval)) + " ");
				}
				if(i == StreamTokenizer.TT_WORD) {
					pwR.write(st.sval + " ");
				}
				if(i == StreamTokenizer.TT_EOL) {
					pwR.println();
					pwN.println();
				}
			}
			pwN.close();
			pwR.close();
			System.out.println("Datei wurde erfolgreich in Zahlen und Wörter gesplitet!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
