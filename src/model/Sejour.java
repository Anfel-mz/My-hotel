package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Sejour extends Reservation {
	static ArrayList<String> miniBarProducts = new ArrayList<String>(Arrays.asList("cocktail","juce","coffee")); 
	static ArrayList <String> services = new ArrayList<String>(Arrays.asList("spa","piscine","golf"));
	
	String id_sej;
	
	private float bill_ch = 0;
	private float bill_mb = 0;
	private float bill_services = 0;

	public Sejour(String id_cl, int num_ch, String deb, String fin) {
		super(id_cl, num_ch, deb, fin);
		
	}

	public void setBillRoom(long p) {
		this.bill_ch =(float) + p;
	}
	
	public void setBillRoom(float p) {
		this.bill_ch =+ p;
	}
	
	public void setBillConso(float p) {
		this.bill_mb =+ p;
	}
	
	public void setBillSer(float p) {
		this.bill_services =+ p;
	}
	
	public float getBillRoom() {
		return this.bill_ch;
	}
	
	public float getBillConso() {
		return this.bill_mb;
	}
	
	public float getBillSer() {
		return this.bill_services;
	}
	
	public float getFullBill() {
		return this.getBillConso()+this.getBillRoom()+this.getBillSer();
	}
	
	public void setId(String id) {
		this.id_sej = id;
	}
	


}
