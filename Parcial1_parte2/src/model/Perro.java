package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;

public class Perro implements Comparable <Perro> {
	
	private String name, race;
	private Date date;
	private int ID, years, meses;
	private PApplet app;
	public Perro( String name, String race, Date date, int years, int meses, int iD, PApplet app) {
		this.name = name;
		this.race = race;
		this.date = date;
		this.years = years;
		this.meses = meses;
		ID = iD;
		this.app = app;
	}
	
	public void pintar(int x) {
		
		app.textSize(14);
	
		app.text("ID: "+ID, x, 100);
		app.text("N: "+ name, x, 120);
		app.text("R: "+race, x, 142);
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(this.date);
		app.text("F: "+date, x, 162);
		app.text("Edad: "+ years + " años y " + meses + " meses", x, 180);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public int compareTo(Perro o) {
		// TODO Auto-generated method stub
		return this.ID - o.getID();
	}

	

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}
	
	
}
