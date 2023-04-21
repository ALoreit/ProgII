package FunktionaleProg.Aufgabe4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import ProgIOTools.IOTools;

public class Aufgabe4a {
	public static ArrayList<String> readTxt() throws FileNotFoundException {
		String filename = "IO/" + IOTools.readLine("Datei Name: ");
		ArrayList<String> stringList = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> stringList.add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return stringList;
	}
	
	public static ArrayList<String> readTxt2 (File f) throws IOException{
		ArrayList<String> stringList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(f));
		while (true) {
			String s = reader.readLine();
			if(s == null) {
				break;
			}
			stringList.add(s);
		}
		return stringList;
	}
	
	public static Person ausString(String s) {
		String [] liste = s.split(";");
		Person p = new Person(liste[1], liste[2], liste[3], liste[4], Integer.parseInt(liste[5]), liste[6]);
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		File f = new File("IO/Personensatz.txt");
		ArrayList<String> l = readTxt2(f);
//		l.stream().limit(14).forEach(System.out::println);
//		l.stream().skip(1).limit(7).forEach(System.out::println);
		LinkedList<Person> daten2 = new LinkedList<>();
		l.stream().skip(1).forEach(s -> daten2.add(ausString(s)));
		
		daten2.stream().filter(p -> p.bundesland.equalsIgnoreCase("Rheinland-Pfalz")).forEach(System.out::println);
		long aelter50 = daten2.stream().filter(p -> p.alter > 50).count();
		System.out.println("Personen über 50: " + aelter50);
		
		}
}
