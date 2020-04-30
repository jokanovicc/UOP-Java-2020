package model.servis;

import model.automobili.Automobil;

public class Deo {
	
	private Automobil automobil;
	private String naziv;
	private double cena;
	
	
	public Deo() {
		this.automobil = new Automobil();
		this.naziv = "";
		this.cena = 0;
	}


	public Deo(Automobil automobil, String naziv, double cena) {
		super();
		this.automobil = automobil;
		this.naziv = naziv;
		this.cena = cena;
	}


	public Automobil getAutomobil() {
		return automobil;
	}


	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	@Override
	public String toString() {
		return "Deo [automobil=" + automobil + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
	
	

}
