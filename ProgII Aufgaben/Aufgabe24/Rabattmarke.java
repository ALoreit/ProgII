package Aufgabe24;

import java.io.Serializable;
import java.util.Date;

public class Rabattmarke implements Serializable{
	private int number;
	private String ownersName;
	private int customerId;
	private int discount;
	private Date release;
	
	
	public Rabattmarke(int number, String name, int customerId, int discount) {
		this.number = number;
		this.ownersName = name;
		this.customerId = customerId;
		this.discount = discount;
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
	
	public String toString() {
		return "Name des Besitzers: " + this.ownersName + "\n Kundennummer: " + this.customerId + "\n Wert: " + this.discount;
	}
}
